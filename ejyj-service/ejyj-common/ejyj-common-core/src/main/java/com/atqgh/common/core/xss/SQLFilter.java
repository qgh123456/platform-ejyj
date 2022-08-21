package com.atqgh.common.core.xss;

import com.atqgh.common.core.exception.MicroException;
import org.apache.commons.lang3.StringUtils;

/**
 * SQL过滤.
 *
 * @author Mark sunlightcs@gmail.com
 */
public class SQLFilter {

    /**
     * SQL注入过滤.
     * @param str  待验证的字符串
     * @return 结果
     */
    public static String sqlInject(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        //去掉'|"|;|\字符
        String newStr = StringUtils.replace(str, "'", "");
        newStr = StringUtils.replace(newStr, "\"", "");
        newStr = StringUtils.replace(newStr, ";", "");
        newStr = StringUtils.replace(newStr, "\\", "");

        //转换成小写
        newStr = newStr.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.indexOf(keyword) != -1) {
                throw new MicroException("包含非法字符");
            }
        }

        return newStr;
    }
}
