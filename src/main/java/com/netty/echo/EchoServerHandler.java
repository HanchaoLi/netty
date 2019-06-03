package com.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private int counter;
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
        /**
         * ByteBuf buf = (ByteBuf) msg;
         * byte[] bytes = new byte[buf.readableBytes()];
         *         buf.readBytes(bytes);
         *         String body = new String(bytes, "UTF-8")
         *        .substring(0, bytes.length - System.getProperty("line.separator")
         *        .length());
         * System.out.println("server get info : " + body + ", get info time: " + ++counter);
         */

        // use LineBaseFrameDecoder and StringDecoder, convert msg to String
        String body = (String) msg;
        System.out.println("server get info : " + body + ", get info time: " + ++counter);

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
