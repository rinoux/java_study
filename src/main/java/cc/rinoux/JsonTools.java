package cc.rinoux;

import com.google.common.base.Joiner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonTools {
    /**
     * 根据fieldNameQueue的字段名依次取值，直到取到非jsonobject， jsonarray的string为止<br>
     * fieldNameQueue是层级关系时，从上到下依次取到string值为止<br>
     * fieldNameQueue是平行关系时，取到第一个string值为止<br>
     *     对于jsonarray，取出每一个的对应字段，并且拼接起来用","分隔
     * @param upperJO 待处理JSONObject
     * @param route 字段名队列，可伸缩变量
     * @return 目标值
     */
    public static String getJsonValueOfKey(JSONObject upperJO, String... route) throws org.json.JSONException {
        String value = null;
        if (route != null) {
            for (String fieldName : route) {
                try {
                    String filedValue = upperJO.getString(fieldName);
                    if (filedValue != null && filedValue.length() > 0) {
                        if (isJsonObject(filedValue)) {//字段值是JSONObject
                            //循环直到取到值
                            value = getJsonValueOfKey(new JSONObject(filedValue), route);
                        } else if (isJsonArray(filedValue)) {
                            //字段值是JSONArray
                            JSONArray ja = new JSONArray(filedValue);
                            Joiner valueJoiner = Joiner.on(",").skipNulls();
                            List<String> valueList = new LinkedList<>();
                            for (int j = 0, len = ja.length(); j < len; j++) {
                                valueList.add(getJsonValueOfKey(ja.getJSONObject(j), route));
                            }
                            value = valueJoiner.join(valueList);
                            break;
                        } else {
                            value = filedValue;
                        }
                    }
                    break;//取到值就停下
                } catch (JSONException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        //如果是日期则规范化格式
        return datetimeFormatter(value);
    }

    /**
     * 使用路径
     * @param father
     * @param route 反映层级关系的路径，例如priority/name
     * @param separate
     * @return
     */
    public static String getJsonValueOfKey(JSONObject father, String route, String separate) {
        String[] hierarchy = route.split(separate);
        return getJsonValueOfKey(father, hierarchy);
    }

    public static String getJsonValueOfKey(JSONObject father, String route) {
        String defaultSep = "/";
        return getJsonValueOfKey(father, route, defaultSep);
    }

    public static int getJsonIntValue(JSONObject father, String route) throws NullPointerException {
        Object value = getJsonValueOfKey(father, route);

        if (value == null) {
            throw new NullPointerException();
        } else {
            return Integer.parseInt(String.valueOf(value));
        }
    }

    public static String getJsonValueOfJsonArray(JSONArray father, int cursor, String... fieldNameQueue) {
        String value = null;
        try {
            value = getJsonValueOfKey((JSONObject) father.get(cursor), fieldNameQueue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //如果是日期则规范化格式
        return datetimeFormatter(value);
    }

    /**
     * 将jira的日期时间格式转换为报表可以使用的格式
     * @param value 原日期时间
     * @return 转换后的日期时间
     */
    public static String datetimeFormatter(String value) {
        if (value != null && value.length() > 0) {
            //正则表达式
            String regex = "(\\d)(\\d)(\\d)(\\d)(-)(\\d)(\\d)(-)(\\d)(\\d)(T)"
                    + "(\\d)(\\d)(:)(\\d)(\\d)(:)(\\d)(\\d)(\\.)"
                    + "(\\d)(\\d)(\\d)(\\+)(\\d)(\\d)(\\d)(\\d)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                int index = value.indexOf(".");
                value = value.substring(0, index);
                value = value.replace('T', ' ');
            }
        }
        return value;
    }

    public static boolean isJsonObject(String json) {
        boolean isJO = false;
        if (json.length() > 0) {
            try {
                JSONObject js = new JSONObject(json);
                isJO = true;
            } catch (JSONException ignored) {

            }
        }
        return isJO;
    }

    public static boolean isJsonArray(String json) {
        boolean isJA = false;
        try {
            if (json.length() > 0) {
                JSONArray ja = new JSONArray(json);
                if(json.contains("{"))
                    isJA = true;
            }
        } catch (JSONException ignored) {

        }

        return isJA;
    }
}
