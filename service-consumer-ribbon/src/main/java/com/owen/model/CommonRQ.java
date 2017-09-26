package com.owen.model;

/**
 * Created by huang_b on 2017/9/15.
 */
public class CommonRQ<T> {
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
