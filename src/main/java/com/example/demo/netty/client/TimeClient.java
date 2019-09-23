package com.example.demo.netty.client;

import com.example.demo.netty.client.handler.TimeClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
    public static void main(String[] args) throws Exception {
        String host = "localhost";//args[0];
        int port = 8080;//Integer.parseInt(args[1]);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            // BootStrap 和 ServerBootstrap 类似,不过他是对非服务端的 channel 而言，比如客户端或者无连接传输模式的 channel
            Bootstrap strap = new Bootstrap();
            // 如果你只指定了一个 EventLoopGroup，那他就会即作为一个 boss group ，也会作为一个 workder group，尽管客户端不需要使用到 boss worker
            strap.group(workGroup);
            // 代替NioServerSocketChannel的是NioSocketChannel,这个类在客户端channel 被创建时使用
            strap.channel(NioSocketChannel.class);
            // 不像在使用 ServerBootstrap 时需要用 childOption() 方法，因为客户端的 SocketChannel 没有父亲
            strap.option(ChannelOption.SO_KEEPALIVE,true);
            strap.remoteAddress(host,port);
            // 不像在使用 ServerBootstrap 时需要用 childOption() 方法，因为客户端的 SocketChannel 没有父亲
            strap.handler(new ChannelInitializer<SocketChannel>() {
                public void initChannel(SocketChannel channel){
                    channel.pipeline().addLast(new TimeClientHandler());
                }
            });
            // 启动客户端
            // 我们用 connect() 方法代替了 bind() 方法
            ChannelFuture future = strap.connect(host,port).sync();
            if (future.isSuccess()) {
                System.out.println("客户端连接服务端成功。");
            }
            // 等待连接关闭
            future.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
        }
    }
}
