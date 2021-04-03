package com.pan.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * 字符串hash操作帮助类
 *
 * @author weiqiang
 */
public class HashesUtil {
    private static final String[][] ESCAPES = {{"+", "_P"}, {"-", "_M"}, {"/", "_S"}, {".", "_D"}, {"=", "_E"}};

    public static String encode(String source) {
        String hash = new String(Base64.encodeBase64(source.getBytes()));
        for (String[] pair : ESCAPES) {
            hash = hash.replace(pair[0], pair[1]);
        }
        return hash;
    }

    public static String decode(String hash) {
        for (String[] pair : ESCAPES) {
            hash = hash.replace(pair[1], pair[0]);
        }
        return new String(Base64.decodeBase64(hash));
    }
}
