package com.xuningxin.utils.rel;

/**
 * Created by xnx on 2018/12/26.
 */
public enum ApiEnum implements ResultMessage {
    API_ERROR("101","接口内部错误"),
    API_SUCCESS("100","接口调用成功");

    String msg;
    String result;
    ApiEnum(String msg,String result){
        this.msg = msg;
        this.result = result;
    }
    ;

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public String getResult() {
        return this.result;
    }
}
