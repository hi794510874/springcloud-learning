package com.owen.model;

import java.io.Serializable;

/**
 * Created by huang_b on 2017/9/15.
 */
public class CommonRQ<T> implements Serializable {
    public HeadRQ getHead() {
        return head;
    }

    public void setHead(HeadRQ head) {
        this.head = head;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HeadRQ head;
    public  T data;
}
