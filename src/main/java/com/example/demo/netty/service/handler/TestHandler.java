package com.example.demo.netty.service.handler;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestHandler extends SimpleChannelInboundHandler<String>{
	
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	for (int i = 0; i < 1000; i++) {   
    		//ByteBuf buffer = getByteBuf(ctx); 
    		ctx.channel().writeAndFlush("服务器 ->你好，我的名字是1234567!\n");
    	}

    	
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		// TODO Auto-generated method stub
		
	}

    
}
