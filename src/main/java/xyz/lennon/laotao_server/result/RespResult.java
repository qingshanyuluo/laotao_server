package xyz.lennon.laotao_server.result;

public class RespResult<T> {

    private int code;

    private String msg;

    private T data;

    public RespResult<T> setCode(RespCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RespResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RespResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}