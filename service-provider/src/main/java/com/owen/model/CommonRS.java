package com.owen.model;

import java.io.Serializable;

/**
 * Created by huang_b on 2017/9/13.
 */
public class CommonRS<T>  implements Serializable {
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    private  T data;
    private  Head head;
}
