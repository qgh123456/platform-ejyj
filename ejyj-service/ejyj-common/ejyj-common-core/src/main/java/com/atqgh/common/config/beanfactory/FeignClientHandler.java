package com.atqgh.common.config.beanfactory;//package com.atqgh.common.config.beanfactory;
//
//import com.atqgh.common.anno.FeignResultHandler;
//import com.atqgh.common.enums.ResultStatus;
//import com.atqgh.common.exception.MicroException;
//import com.atqgh.common.utils.JsonUtils;
//import com.atqgh.common.utils.ResultObj;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Objects;
//import lombok.NonNull;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.ObjectUtils;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//
///**
// * feignClient的结果的代理.
// *
// * @author Mubai
// * @since 2022/8/7 7:06 下午
// **/
//@Slf4j
//public class FeignClientHandler implements InvocationHandler {
//
//    private String[] exclusionMethods;
//
//    private String msg;
//
//    private final Object target;
//
//    private final FeignResultHandler annotation;
//
//    public FeignClientHandler(Object target, FeignResultHandler annotation) {
//
//        this.target = target;
//        this.annotation = annotation;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) {
//
//        Object obj;
//        try {
//            obj = method.invoke(target, args);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            throw new MicroException(ResultStatus.UNIVERSAL_HANDLER_ERROR.getCode(), "", e);
//        }
//        // 获取方法上的代理注解
//        if (ObjectUtils.isNotEmpty(annotation) && obj instanceof ResultObj) {
//            ResultObj result = (ResultObj) obj;
//            if (checkProxyMethod(annotation, method.getName())) {
//                if (!ResultStatus.SUCCESS.getCode().equals(result.getCode())) {
//                    log.error(getMsg(annotation) + " feign接口返回内容: {}", JsonUtils.toString(result));
//                    throw new MicroException(ResultStatus.BUSINESS_REQUEST_FAILED.getCode(), getMsg(annotation) + " " + JsonUtils.toString(result));
//                }
//            }
//        }
//        return obj;
//    }
//
//    private String getMsg(@NonNull FeignResultHandler annotation) {
//
//        if (Objects.isNull(msg)) {
//            this.msg = annotation.msg();
//        }
//        return msg;
//    }
//
//    private boolean checkProxyMethod(@NonNull FeignResultHandler annotation, @NonNull String methodName) {
//
//        if (Objects.isNull(exclusionMethods)) {
//            exclusionMethods = annotation.exclusionMethods();
//        }
//        for (String exclusionMethod : exclusionMethods) {
//            if (methodName.equals(exclusionMethod)) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
