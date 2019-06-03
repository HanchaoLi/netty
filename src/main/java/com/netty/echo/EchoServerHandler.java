package com.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        /** three ways to write data
         *
         * first:
         * Channel channel = ctx.channel();
         * channel.writeAndFlush(Unpooled.copiedBuffer("xxxxx", CharsetUtil.UTF-8));
         *
         * second:
         * ChannelPipeline channelPipeline = ctx.pipeline();
         * channelPipeline.writeAndFlush(Unpooled.copiedBuffer("xxxxx", CharsetUtil.UTF-8));
         *
         * thrid:
         * ctx.writeAndFlush(Unpooled.copiedBuffer("xxxxx", CharsetUtil.UTF-8))
        */
        ByteBuf data = (ByteBuf) msg;
        System.out.println("server get data: " + data.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(data);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("call channelReadComplete");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
