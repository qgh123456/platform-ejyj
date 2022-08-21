package com.atqgh.common.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 分页帮助类.
 *
 * @author Mubai
 * @since 2022/8/13 10:58 下午
 **/
public class PageableHelpUtil {

    /**
     * 分页.
     * @param request 请求
     * @return 结果
     */
    public static Pageable startPage(ServletRequest request) {
        String pageString = request.getParameter("page");
        String pageSizeString = request.getParameter("pageSize");
        int page = pageString == null ? 0 : Integer.parseInt(pageString);
        int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
        String sorts = request.getParameter("sorts");
        if (StringUtils.isBlank(sorts)) {
            return PageRequest.of(page, pageSize);
        } else {
            List<String> sortList = Arrays.asList(sorts.split(","));
            List<Sort.Order> list = new ArrayList();
            sortList.forEach(field -> {
                String[] split = field.split(":");
                Sort.Order order = new Sort.Order(split[1].toUpperCase().equals(Sort.Direction.ASC.toString()) ? Sort.Direction.ASC : Sort.Direction.DESC, split[0]);
                list.add(order);
            });
            return PageRequest.of(page, pageSize, Sort.by(list));
        }
    }

    /**
     * 排序.
     * @param sort 排序
     * @return 结果
     */
    public static String getOrders(Sort sort) {
        if (sort != null && !sort.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            sort.stream().forEach(item -> {
                stringBuilder.append(item.getProperty());
                stringBuilder.append(" ");
                stringBuilder.append(item.getDirection());
                stringBuilder.append(" ,");
            });
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        } else {
            return null;
        }
    }
}
