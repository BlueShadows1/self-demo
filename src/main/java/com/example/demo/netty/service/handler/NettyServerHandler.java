package com.example.demo.netty.service.handler;

import com.example.demo.netty.util.ByteBufFormat;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush("Server -> Client Hello!");
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception {
        try {
            ByteBuf in = ByteBufFormat.format(msg.toString());
            System.out.println("------收到客户端消息-------");
            System.out.println(in.toString(CharsetUtil.UTF_8));
            ctx.writeAndFlush(msg);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
