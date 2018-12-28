package com.xuningxin.utils.web;

import com.xuningxin.utils.rel.ResultMessage;

/**
 * Created by xnx on 2018/12/26.
 * 返回值封装
 */
public class Result {

    protected String result;
    protected String msg;
    protected Object data;

    public Result(ResultMessage message) {
        super();
        this.result = message.getResult();
        this.msg = message.getMsg();
    }

    public Result(ResultMessage message, Object data) {
        super();
        this.result = message.getResult();
        this.msg = message.getMsg();
        this.data = data;
    }

    public Result(ResultMessage message, Class tClass) {
        super();
        this.result = message.getResult();
        this.msg = message.getMsg() + " - " + tClass.getSimpleName();
    }

    public Result(ResultMessage message, Class tClass, String custommsg) {
        super();
        this.result = message.getResult();
        this.msg = tClass.getSimpleName() + " " + message.getMsg() + " - " + custommsg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public String toString(){
        String str = "";
        str += "返回值：" + getMsg() + "\n";
        str += "返回信息：" + getResult() + "\n";
        return str;
    }

    public static boolean isOk(Result r){
        if (r.getResult().equals(ResultMessage.Base.OK.getResult()))
            return true;
        else
            return false;
    }

}
