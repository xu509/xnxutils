package com.xuningxin.utils.rel;

/**
 * Created by xnx on 2018/12/26.
 */
public interface ResultMessage {

    String getMsg();

    String getResult();

    /**
     *  基础返回
     */
    enum Base implements ResultMessage{
        OK("0","成功"),
        ERROR("1","错误");

        private String result;
        private String msg;

        Base(String result,String msg){
            this.result = result;
            this.msg = msg;
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
    }
}
