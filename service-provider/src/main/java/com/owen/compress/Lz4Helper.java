package com.owen.compress;

import net.jpountz.lz4.*;

import java.io.*;

import static net.jpountz.lz4.LZ4Factory.*;

/**
 * Created by huang_b on 2017/12/6.
 */
public class Lz4Helper {
    public static byte[] lz4Compress(byte[] data) throws IOException {
        LZ4Factory factory = fastestInstance();
//        factory.highCompressor(6);
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        LZ4Compressor compressor = factory.fastCompressor();
        LZ4BlockOutputStream compressedOutput = new LZ4BlockOutputStream(byteOutput, 8192, compressor);
        compressedOutput.write(data);
        compressedOutput.close();
        return byteOutput.toByteArray();
    }

    public static byte[] lz4DecompressReturnBytes(byte[] data) throws IOException {
        LZ4Factory factory = fastestInstance();
        ByteArrayOutputStream baos = new ByteArrayOutputStream(8192);
        LZ4FastDecompressor decompresser = factory.fastDecompressor();
        LZ4BlockInputStream lzis = new LZ4BlockInputStream(new ByteArrayInputStream(data), decompresser);
        int count;
        byte[] buffer = new byte[8192];
        while ((count = lzis.read(buffer)) != -1) {
            baos.write(buffer, 0, count);
        }
        lzis.close();
        return baos.toByteArray();
    }

    public static <T> byte[] lz4Compress(T t) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(t);
        byte[] bytes = bo.toByteArray();

        byte[] result = lz4Compress(bytes);
        return result;
    }

    public static <T> T lz4Decompress(byte[] bytes) throws IOException, ClassNotFoundException {
        byte[] temp = lz4DecompressReturnBytes(bytes);
        T t = null;
        ByteArrayInputStream bi = new ByteArrayInputStream(temp);
        ObjectInputStream oi = new ObjectInputStream(bi);

        t = (T) oi.readObject();
        return t;
    }
}
