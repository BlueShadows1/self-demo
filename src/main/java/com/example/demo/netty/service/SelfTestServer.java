package com.example.demo.netty.service;

import com.example.demo.netty.service.handler.TestHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.EventExecutorGroup;

public class SelfTestServer {
	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup workGroup = new NioEventLoopGroup();
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workGroup);
		b.channel(NioServerSocketChannel.class);
		b.childHandler(new ChannelInitializer<SocketChannel>() {
			public void initChannel(SocketChannel s) {
				s.pipeline().addLast("framer", new FixedLengthFrameDecoder(5));
                s.pipeline().addLast("encoder",new StringEncoder());
                s.pipeline().addLast("decoder",new StringDecoder());
                
                s.pipeline().addLast("handler",new TestHandler());
			}
		});
		ChannelFuture f = b.bind(8888).sync();
		
	}

}
