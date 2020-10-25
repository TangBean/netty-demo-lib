package io.netty.example.study.client.handler.dispatch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import io.netty.example.study.common.OperationResult;

public class RequestPendingCenter {

    private Map<Long, OperationResultFuture> opResMap = new ConcurrentHashMap<>();

    public void add(Long streamId, OperationResultFuture future) {
        opResMap.put(streamId, future);
    }

    public void set(Long streamId, OperationResult result) {
        OperationResultFuture operationResultFuture = opResMap.get(streamId);
        if (operationResultFuture != null) {
            operationResultFuture.setSuccess(result);
            opResMap.remove(streamId);
        }
    }

}
