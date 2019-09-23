package com.example.demo.netty.service.handler;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private final String url;
    private static final File index;
    static {
        URL location = HttpRequestHandler.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            String path = location.toURI() + "WebSocketChatClient.html";
            path = path.contains("file:") ? path.substring(5) : path;
            index = new File(path);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("unable to locate WebSocketChatClient.html");
        }
    }

    public HttpRequestHandler(String url) {
        this.url = url;
    }
    @Override
    public void channelRead0(ChannelHandlerContext ctx,FullHttpRequest req) throws Exception{
        if (url.equalsIgnoreCase(req.getUri())) {
            ctx.fireChannelRead(req.retain());
        } else {
            if (HttpHeaders.is100ContinueExpected(req)) {
                send100Continue(ctx);
            }
            RandomAccessFile file = new RandomAccessFile(index, "r");
            HttpResponse response = new DefaultHttpResponse(req.getProtocolVersion(), HttpResponseStatus.OK);
            response.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/html;charset=UTF-8");
            boolean keepAlive = HttpHeaders.isKeepAlive(req);
            if (keepAlive) {
                response.headers().set(HttpHeaders.Names.CONTENT_LENGTH, file.length());
                response.headers().set(HttpHeaders.Names.CONNECTION,HttpHeaders.Values.KEEP_ALIVE);
            }
            ctx.writeAndFlush(response);
            if (ctx.pipeline().get(SslHandler.class) == null) {
                ctx.write(new DefaultFileRegion(file.getChannel(), 0, file.length()));
            } else {
                ctx.write(new ChunkedNioFile(file.getChannel()));
            }
            ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
            if (!keepAlive) {
                future.addListener(ChannelFutureListener.CLOSE);
            }
            file.close();
        }
    }

    public static void send100Continue(ChannelHandlerContext ctx) {
        FullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE);
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable throwable) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("Client"+ incoming.remoteAddress() + "异常");
        throwable.printStackTrace();
        ctx.close();
    }
}
