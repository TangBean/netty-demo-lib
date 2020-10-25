package io.netty.example.study.server.codec;

import io.netty.handler.codec.LengthFieldPrepender;

import java.nio.ByteOrder;

public class OrderFrameEncoder extends LengthFieldPrepender {
    public OrderFrameEncoder() {
        super(2);
    }
}
