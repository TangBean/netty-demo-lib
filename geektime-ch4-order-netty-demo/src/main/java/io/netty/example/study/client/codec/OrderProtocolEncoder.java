package io.netty.example.study.client.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.study.common.RequestMessage;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 为了方便，写这个类的时候可以直接从 Server 里 copy 代码过来，不过一定要记得改下：ResponseMessage -> RequestMessage
 */
public class OrderProtocolEncoder extends MessageToMessageEncoder<RequestMessage> {

    @Override
    protected void encode(ChannelHandlerContext ctx, RequestMessage msg, List<Object> out) throws Exception {
        ByteBuf buf = ctx.alloc().buffer();
        msg.encode(buf);

        out.add(buf);
    }
}