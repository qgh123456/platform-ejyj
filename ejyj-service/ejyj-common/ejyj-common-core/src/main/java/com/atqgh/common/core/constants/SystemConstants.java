package com.atqgh.common.core.constants;

/**
 * 系统管理常量.
 * @author Mubai
 * @date 2022/7/9 4:26 下午
 **/
public interface SystemConstants {

    class Role {

        /**
         * 超级管理员.
         */
        public static final String ADMIN = "admin";

        /**
         * 普通管理员.
         */
        public static final String COMMON = "common";
    }

    class Perm {

        /**
         * 超级管理员权限.
         */
        public static final String ADMIN_PERS = "*:*:*";

    }

}
