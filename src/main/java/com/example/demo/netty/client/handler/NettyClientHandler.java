package com.example.demo.netty.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush("Client -> Server Hello!");
    }
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception{
        try {
            ByteBuf in = Unpooled.buffer().writeBytes(msg.toString().getBytes("utf-8"));
            System.out.println(msg);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
