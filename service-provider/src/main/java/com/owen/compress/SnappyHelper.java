package com.owen.compress;

import com.google.common.primitives.Bytes;
import org.xerial.snappy.Snappy;

import java.io.*;

/**
 * Created by huang_b on 2017/12/6.
 */
public  class SnappyHelper{

    public static byte[] snappyCompress(byte[] params) throws IOException {
        byte[] bytes = Snappy.compress(params);
        return bytes;
    }

    public static byte[] snappyDeCompressRetutnBytes(byte[] params) throws IOException {
        byte[] bytes = Snappy.uncompress(params);
        return bytes;
    }

    public static<T> byte[] snappyCompress(T t) throws IOException {

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(t);

        byte[] bytes = bo.toByteArray();

        byte[] result = snappyCompress(bytes);
        return result;

    }

    public static<T> T snappyDeCompress(byte[] params) throws IOException, ClassNotFoundException {
        byte[] bytes = snappyDeCompressRetutnBytes(params);
        T t = null;
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream oi = new ObjectInputStream(bi);

        t = (T) oi.readObject();
        return t;
    }
}
