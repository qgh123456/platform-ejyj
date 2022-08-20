package com.atqgh.common.security.utils;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * web处理类.
 * @author Mubai
 * @date 2022/7/9 4:29 下午
 **/
@Slf4j
public class WebUtils {

    /**
     * 将字符串渲染到客户端.
     *
     * @param response 渲染对象
     * @param string 待渲染的字符串
     * @return 结果
     */
    public static String renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
