package com.xuningxin.utils;

/**
 * Created by xnx on 2018/12/26.
 * 生成器，可通过实现该接口，调用next（）方法获取实例，即可不再考虑生成过程。
 */
public interface Generator<T> {

    T next();

}
