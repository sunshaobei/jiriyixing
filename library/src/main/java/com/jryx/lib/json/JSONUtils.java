package com.jryx.lib.json;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by sunsh on 2017/6/7.
 */
public class JSONUtils {
    private JSONUtils() {
        throw new UnsupportedOperationException("this method disallow to use");
    }

    private static JSONObject object = new JSONObject();

    public static JSONObject toJson(String json) throws JSONException {
        return object.getJSONObject(json);
    }

    /**
     * 对象装JSON字符串
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * json字符串转对象
     *
     * @param json
     * @param tClass
     * @return
     */
    public static <T> T fromJson(String json, Class<T> tClass) {
        return JSON.parseObject(json, tClass);
    }

    /**
     * json字符串转List
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Type type) {
        return JSON.parseObject(json, type);
    }
}
