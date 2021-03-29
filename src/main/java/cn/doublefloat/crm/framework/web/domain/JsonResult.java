package cn.doublefloat.crm.framework.web.domain;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 9:03 上午
 */

public class JsonResult extends HashMap<String, Object> {

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 JsonResult 对象，使其表示一个空消息。
     */
    public JsonResult() {
    }

    /**
     * 初始化一个新创建的 JsonResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public JsonResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 JsonResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public JsonResult(HttpStatus code, String msg, Object data) {
        super.put(CODE_TAG, code.value());
        super.put(MSG_TAG, msg);
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static JsonResult success() {
        return JsonResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static JsonResult success(Object data) {
        return JsonResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static JsonResult success(String msg) {
        return JsonResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static JsonResult success(String msg, Object data) {
        return new JsonResult(HttpStatus.OK, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static JsonResult error() {
        return JsonResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static JsonResult error(String msg) {
        return JsonResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static JsonResult error(String msg, Object data) {
        return new JsonResult(HttpStatus.INTERNAL_SERVER_ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static JsonResult error(HttpStatus code, String msg) {
        return new JsonResult(code, msg, null);
    }
}
