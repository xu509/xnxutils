package com.xuningxin.utils.common;

import com.xuningxin.utils.rel.IdWorker;

import java.util.UUID;

/**
 * Created by xnx on 2018/12/26.
 * ID 生成器
 */
public class IdGenerator implements Generator<String> {

    private static final IdWorker worker = new IdWorker(1);

    /**
     *  通过时间生成ID （19位）
     */
    public static String generateId() {
        return String.valueOf(worker.nextId());
    }

    public static String generateIdByUUID(){
        return UUID.randomUUID().toString();
    }

    @Override
    public String next() {
        return generateId();
    }
}
