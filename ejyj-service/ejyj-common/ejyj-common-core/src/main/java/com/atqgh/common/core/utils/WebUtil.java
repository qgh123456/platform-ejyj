package com.atqgh.common.core.utils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * web工具类.
 * @author Mubai
 * @date 2022/6/30 5:55 下午
 **/
@Slf4j
public class WebUtil {

    /**
     * 设置响应.
     *
     * @param response    HttpServletResponse
     * @param contentType content-type
     * @param status      http状态码
     * @param value       响应内容
     * @throws IOException IOException
     */
    public static void makeResponse(HttpServletResponse response, String contentType,
                                    int status, Object value) throws IOException {

        response.setContentType(contentType);
        response.setStatus(status);
        response.getOutputStream().write(JSONObject.toJSONString(value).getBytes());
    }

    /**
     * 获取HttpServletRequest请求对象.
     *
     * @return HttpServletRequest请求对象
     */
    public static HttpServletRequest getRequest() {

        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
    }

    /**
     * 开启分页查询.
     */
    public static void startPage() {

        HttpServletRequest request = getRequest();
        Pageable pageable = PageableHelpUtil.startPage(request);
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize(),
                PageableHelpUtil.getOrders(pageable.getSort()));
    }

    /**
     * 清除分页.
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }

    /**
     * 重新设置分页.
     *
     * @param pageNum 分页开始位置
     * @param pageSize 页大小
     * @param orderBy 排序
     */
    public static void resetPage(int pageNum, int pageSize, String orderBy) {
        PageHelper.startPage(pageNum, pageSize, orderBy);
    }

}
