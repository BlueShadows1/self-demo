package com.example.demo.netty.service.handler;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


public class WebsocketChatServerInitializer extends
        ChannelInitializer<SocketChannel> { //1

    @Override
    public void initChannel(io.netty.channel.socket.SocketChannel ch) throws Exception {//2
        ChannelPipeline pipeline = ch.pipeline();

        // 将请求和应答消息解码为http消息
        pipeline.addLast(new HttpServerCodec());
        // httpObjectAggregator:将http消息多个部分合成一条完整的http消息
        pipeline.addLast(new HttpObjectAggregator(64*1024));
        // ChunkedWriteHandler:向客户端发送HTML5文件
        pipeline.addLast(new ChunkedWriteHandler());
        // 管道中实现自定义接受数据、编辑数据的方法
        pipeline.addLast(new HttpRequestHandler("/ws")); // 自定义handler
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(new TextWebSocketFrameHandler()); // 自定义handler

    }
}