package utils.base.jh.com.jhbaselibrary;

import org.json.JSONException;
import org.json.JSONObject;

public class JHJsonUtils {

    private JHJsonUtils() {
    }

    /**
     * 根据字段获取相应的字段值 String
     *
     * @param js           相应的JSONObject
     * @param name         字段名
     * @param defaultValue 默认值
     * @return
     * @throws JSONException
     */
    public static String getString(JSONObject js, String name, String defaultValue) throws JSONException {
        return js.has(name) ? js.getString(name) : defaultValue;
    }

    /**
     * 根据字段获取相应的字段值 String  默认值是 ""
     *
     * @param js   相应的JSONObject
     * @param name 字段名
     * @return
     * @throws JSONException
     */
    public static String getString(JSONObject js, String name) throws JSONException {
        return js.has(name) ? js.getString(name) : "";
    }

    /**
     * 根据字段获取相应的字段值 Int
     *
     * @param js            相应的JSONObject
     * @param name          字段名
     * @param defaultValue  默认值
     * @return
     * @throws JSONException
     */
    public static int getInt(JSONObject js, String name, int defaultValue) throws JSONException {
        return js.has(name) ? js.getInt(name) : defaultValue;
    }

    /**
     * 根据字段获取相应的字段值 Int  默认值是0
     *
     * @param js   相应的JSONObject
     * @param name 字段名
     * @return
     * @throws JSONException
     */
    public static int getInt(JSONObject js, String name) throws JSONException {
        return js.has(name) ? js.getInt(name) : 0;
    }



}