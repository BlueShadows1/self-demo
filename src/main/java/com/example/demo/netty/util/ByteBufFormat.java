package com.example.demo.netty.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.UnsupportedEncodingException;

public  class ByteBufFormat {
    public static ByteBuf format(String str) throws UnsupportedEncodingException {
       return Unpooled.buffer().writeBytes(str.getBytes("utf-8"));
    }
}
