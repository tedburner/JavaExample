package com.example.test.builder;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/23 09:42
 * @description:
 */
public class ResponseModel<T> {

    private T data;
    private String msg;
    private String code;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public static final class ResponseModelBuilder<T> {
        private T data;
        private String msg;
        private String code;

        private ResponseModelBuilder() {
        }

        public static ResponseModelBuilder aResponseModel() {
            return new ResponseModelBuilder();
        }

        public ResponseModelBuilder data(T data) {
            this.data = data;
            return this;
        }

        public ResponseModelBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ResponseModelBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ResponseModel build() {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setData(data);
            responseModel.setMsg(msg);
            responseModel.setCode(code);
            return responseModel;
        }
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
