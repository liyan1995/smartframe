package cn.liyan.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * create by YanL on 2019/1/8
 */
public final class StringUtil {

    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String[]  splitString(String body, String regex) {
        return StringUtils.split(body, regex);
    }
}
