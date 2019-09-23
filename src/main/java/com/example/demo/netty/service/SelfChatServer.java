package com.example.demo.netty.service;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.EventExecutorGroup;

public class SelfChatServer {
	public void run () {
		// 服务端监听者？
		EventExecutorGroup bossGroup = new NioEventLoopGroup();
		// 客户端发送消息后，boss监听到消息然后将信息发给work组去处理
		EventExecutorGroup workGroup = new NioEventLoopGroup();
		
	}

}
