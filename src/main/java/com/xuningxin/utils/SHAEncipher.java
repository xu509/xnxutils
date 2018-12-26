package com.xuningxin.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by xnx on 2018/12/26.
 */
public class SHAEncipher implements Encipher {

    public static final String KEY_SHA = "SHA";

    @Override
    public String encrypt(String str) {
        BigInteger sha = null;
        byte[] inputData = str.getBytes();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return sha.toString(32);
    }

    @Override
    public String decrypt(String str) {
        System.out.println("SHA CAN NOT DECRYPT.");
        return null;
    }
}