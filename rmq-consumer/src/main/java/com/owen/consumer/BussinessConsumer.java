package com.owen.consumer;

import com.owen.DealMessageResult;

/**
 * Created by huang_b on 2018/2/6.
 */
public class BussinessConsumer extends BaseConsumer {
    @Override
    public DealMessageResult handleMessage(String msg) {
        DealMessageResult dealMessageResult = new DealMessageResult();
        System.out.println(" [x] Received '" + msg + "'");

        return dealMessageResult;
    }
}
