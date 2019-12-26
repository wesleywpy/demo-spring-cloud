package com.wesley.auth;

import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/12/18
 */
public class HttpBasicTest {

    public void encode() {

    }

    public static void main(String[] args) throws IOException {
//        String code = "b3JkZXJTZXJ2aWNlOjEyMzQ1Ng==";
//        BASE64Decoder base64Decoder = new BASE64Decoder();
//        byte[] decode = base64Decoder.decodeBuffer(code);
//        System.out.println(new String(decode));

        BASE64Encoder encoder = new BASE64Encoder();
        String code = "gateway:123456";
        String basic = encoder.encode(code.getBytes());
        System.out.println(basic);

    }
}
