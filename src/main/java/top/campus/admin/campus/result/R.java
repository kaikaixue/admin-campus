package top.campus.admin.campus.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    private Boolean success;
    private Integer code;
    private String message;

    private Map<String,Object> data = new HashMap<>();

    public R() {}

    /**
     * 功能描述
     *
     * @return R 成功返回结果
     */
    public static R ok() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    /**
     * 功能描述
     *
     * @return R 失败返回结果
     */
    public static R error() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        return r;
    }

    /**
     * 功能描述：设置返回结果
     *
     * @return R 返回给前端的结果
     */
    public static R setResult(ResultCodeEnum resultCodeEnum) {
        R r = new R();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }

    /**
     * 功能描述：设置success状态
     *
     * @return R 返回给前端的数据
     */
    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    /**
     * 功能描述：设置message内容
     *
     * @return R 返回给前端的数据
     */
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 功能描述：设置code内容
     *
     * @return R 返回给前端的数据
     */
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * 功能描述：单值设置数据
     *
     * @return R 返回给前端的数据
     */
    public R data(String key,Object value) {
        this.data.put(key,value);
        return this;
    }

    /**
     * 功能描述：多值设置数据
     *
     * @return R 返回给前端的数据
     */
    public R data(Map<String,Object> map) {
        this.setData(map);
        return this;
    }
}

