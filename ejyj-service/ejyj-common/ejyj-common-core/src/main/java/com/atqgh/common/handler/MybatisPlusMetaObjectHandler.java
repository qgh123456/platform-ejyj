package com.atqgh.common.handler;

import com.atqgh.common.utils.WebUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.util.Date;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.ibatis.reflection.MetaObject;

public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    private static final String AUTHUSERID = "authorization-userId";

    private static final String CREATE_USER = "createUser";

    private static final String CREATE_TIME = "createTime";

    private static final String UPDATE_USER = "updateUser";

    private static final String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {

        Integer userId = getUserId();
        Date now = new Date();
        //创建人
        setFieldValByNameIfNull(CREATE_USER, userId, metaObject);
        //创建时间
        setFieldValByNameIfNull(CREATE_TIME, now, metaObject);
        //更新人
        setFieldValByNameIfNull(UPDATE_USER, userId, metaObject);
        //更新时间
        setFieldValByNameIfNull(UPDATE_TIME, now, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新人
        setFieldValByNameIfNull(UPDATE_USER, getUserId(), metaObject);
        //更新时间
        setFieldValByNameIfNull(UPDATE_TIME, new Date(), metaObject);
    }

    private void setFieldValByNameIfNull(String fieldName, Object value, MetaObject metaObject) {

        Object oldValue = getFieldValByName(fieldName, metaObject);
        if (Objects.isNull(oldValue)) {
            setFieldValByName(fieldName, value, metaObject);
        }
    }

    private Integer getUserId() {

        HttpServletRequest request = WebUtil.getRequest();
        String userId = request.getHeader(AUTHUSERID);
        if (ObjectUtils.isNotEmpty(userId)) {
            return Integer.valueOf(userId);
        }
        return null;
    }
}
