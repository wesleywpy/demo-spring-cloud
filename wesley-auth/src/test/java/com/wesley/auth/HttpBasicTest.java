package com.wesley.auth;

import sun.misc.BASE64Decoder;

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
        String code = "b3JkZXJTZXJ2aWNlOjEyMzQ1Ng==";
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] decode = base64Decoder.decodeBuffer(code);
        System.out.println(new String(decode));
//        Base64.Encoder encoder = Base64.getEncoder();
//        String basic = encoder.encodeToString(code.getBytes());
//        BASE64Encoder encoder = new BASE64Encoder();
//        String basic = encoder.encode(code.getBytes());
//        System.out.println(basic);

    }
}
