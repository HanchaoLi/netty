package com.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {


//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ByteBuf mes = null;
//        byte[] req = ("client.message" + System.getProperty("line.separator")).getBytes();
//        for (int i = 0; i < 10; i++) {
//            mes = Unpooled.buffer(req.length);
//            mes.writeBytes(req);
//            ctx.writeAndFlush(mes);
//        }
//    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String message = "Netty is a NIO client server framework &_" +
                "which enables quick and easy development of network &_" +
                "applications such as protocol servers and clients. &_" +
                "It greatly simplifies and streamlies network &_" +
                "programming such as TCP and UDP socket server.&_";
        ByteBuf mes = null;
        mes = Unpooled.buffer(message.getBytes().length);
        mes.writeBytes(message.getBytes());
        ctx.writeAndFlush(mes);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
