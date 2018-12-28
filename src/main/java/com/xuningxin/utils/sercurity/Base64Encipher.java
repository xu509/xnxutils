package com.xuningxin.utils.sercurity;

import java.util.Base64;

/**
 * Created by xnx on 2018/12/26.
 */
public class Base64Encipher implements Encipher {


    @Override
    public String encrypt(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    @Override
    public String decrypt(String str) {
        try {
            return new String(Base64.getDecoder().decode(str));
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
