package com.example.demo.netty.client;

import com.example.demo.netty.client.handler.NettyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyClient {
    public static void main(String[] args)  throws Exception{
        String host = "localhost";
        int port = 8888;
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workGroup);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.channel(NioSocketChannel.class);
            b.remoteAddress(host, port);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {
                	ch.pipeline().addLast("framer",new FixedLengthFrameDecoder(100));
                    ch.pipeline().addLast("encoder",new StringEncoder());
                    ch.pipeline().addLast("decoder",new StringDecoder());
                    ch.pipeline().addLast(new NettyClientHandler());
                }
            });
            ChannelFuture f = b.connect(host, port).sync();
            if (f.isSuccess()) {
                System.out.println("客户端连接服务端成功。");
            }
            f.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
        }
    }
}
