package xyz.lennon.laotao_server.result;

public class RespUtil {

    private final static String SUCCESS = "success";

    public static <T> RespResult<T> makeOKRsp() {
        return new RespResult<T>().setCode(RespCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> RespResult<T> makeOKRsp(T data) {
        return new RespResult<T>().setCode(RespCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> RespResult<T> makeErrRsp(String message) {
        return new RespResult<T>().setCode(RespCode.FAIL).setMsg(SUCCESS);
    }

    public static <T> RespResult<T> makeRsp(int code, String msg) {
        return new RespResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> RespResult<T> makeRsp(int code, String msg, T data) {
        return new RespResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
