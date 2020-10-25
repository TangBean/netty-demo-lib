package io.netty.example.study.client.handler.dispatch;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.example.study.common.ResponseMessage;
import io.netty.util.concurrent.DefaultPromise;

public class ResponseDispatchHandler extends SimpleChannelInboundHandler<ResponseMessage> {

    private RequestPendingCenter requestPendingCenter;

    public ResponseDispatchHandler(RequestPendingCenter requestPendingCenter) {
        this.requestPendingCenter = requestPendingCenter;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponseMessage msg) throws Exception {
        requestPendingCenter.set(msg.getMessageHeader().getStreamId(), msg.getMessageBody());
    }
}
