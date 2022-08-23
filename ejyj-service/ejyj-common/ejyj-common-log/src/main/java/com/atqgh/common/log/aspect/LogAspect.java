//package com.atqgh.common.log.aspect;
//
//import com.atqgh.common.core.utils.JsonUtils;
//import com.atqgh.common.core.utils.ServletUtils;
//import com.atqgh.common.core.utils.WebUtil;
//import com.atqgh.common.core.utils.ip.IpUtils;
//import com.atqgh.common.log.annotation.Log;
//import com.atqgh.common.log.enums.BusinessStatus;
//import com.atqgh.common.log.service.AsyncLogService;
//import com.atqgh.system.api.vo.SysOperLogVo;
//import java.util.Collection;
//import java.util.Map;
//import java.util.Objects;
//import javax.annotation.Resource;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.ObjectUtils;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.validation.BindingResult;
//
///**
// * 操作日志记录处理.
// *
// * @author Mubai
// * @since 2022/8/7 7:06 下午
// */
//@Aspect
//@Component
//@Slf4j
//public class LogAspect {
//
//    @Resource
//    private AsyncLogService asyncLogService;
//
//    /**
//     *  处理完请求后执行.
//     * @param joinPoint 切点
//     * @param controllerLog 日志注解
//     * @param jsonResult 处理结果
//     */
//    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "jsonResult")
//    public void doAfterReturning(JoinPoint joinPoint, Log controllerLog, Object jsonResult) {
//        handleLog(joinPoint, controllerLog, null, jsonResult);
//    }
//
//    /**
//     * 拦截异常操作.
//     * @param joinPoint 切点
//     * @param controllerLog 日志注解
//     * @param e 异常
//     */
//    @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
//    public void doAfterThrowing(JoinPoint joinPoint, Log controllerLog, Exception e) {
//        handleLog(joinPoint, controllerLog, e, null);
//    }
//
//    protected void handleLog(final JoinPoint joinPoint, Log controllerLog, final Exception e, Object jsonResult) {
//
//        try {
//            // *========数据库日志=========*//
//            SysOperLogVo operLog = new SysOperLogVo();
//            operLog.setStatus(BusinessStatus.SUCCESS.ordinal());
//            // 请求的地址
//            String ip = IpUtils.getIpAddr(WebUtil.getRequest());
//            operLog.setOperIp(ip);
//            operLog.setOperUrl(Objects.requireNonNull(ServletUtils.getRequest()).getRequestURI());
//            String username = SecurityUtils.getUsername();
//            if (ObjectUtils.isNotEmpty(username)) {
//                operLog.setOperName(username);
//            }
//
//            if (e != null) {
//                operLog.setStatus(BusinessStatus.FAIL.ordinal());
//                operLog.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
//            }
//            // 设置方法名称
//            String className = joinPoint.getTarget().getClass().getName();
//            String methodName = joinPoint.getSignature().getName();
//            operLog.setMethod(className + "." + methodName + "()");
//            // 设置请求方式
//            operLog.setRequestMethod(ServletUtils.getRequest().getMethod());
//            // 处理设置注解上的参数
//            getControllerMethodDescription(joinPoint, controllerLog, operLog, jsonResult);
//            // 保存数据库
//            asyncLogService.saveSysLog(operLog);
//        } catch (Exception exp) {
//            // 记录本地异常日志
//            log.error("==前置通知异常==");
//            log.error("异常信息:{}", exp.getMessage());
//            exp.printStackTrace();
//        }
//    }
//
//    /**
//     * 获取注解中对方法的描述信息 用于Controller层注解.
//     *
//     * @param log 日志
//     * @param operLog 操作日志
//     * @throws Exception 异常
//     */
//    public void getControllerMethodDescription(JoinPoint joinPoint, Log log, SysOperLogVo operLog, Object jsonResult) throws Exception {
//
//        // 设置action动作
//        operLog.setBusinessType(log.businessType().ordinal());
//        // 设置标题
//        operLog.setTitle(log.title());
//        // 设置操作人类别
//        operLog.setOperatorType(log.operatorType().ordinal());
//        // 是否需要保存request，参数和值
//        if (log.isSaveRequestData()) {
//            // 获取参数的信息，传入到数据库中。
//            setRequestValue(joinPoint, operLog);
//        }
//        // 是否需要保存response，参数和值
//        if (log.isSaveResponseData() && StringUtils.isNotNull(jsonResult)) {
//            operLog.setJsonResult(StringUtils.substring(JsonUtils.toString(jsonResult), 0, 2000));
//        }
//    }
//
//    /**
//     * 获取请求的参数，放到log中.
//     *
//     * @param operLog 操作日志
//     * @throws Exception 异常
//     */
//    private void setRequestValue(JoinPoint joinPoint, SysOperLogVo operLog) throws Exception {
//        String requestMethod = operLog.getRequestMethod();
//        if (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod)) {
//            String params = argsArrayToString(joinPoint.getArgs());
//            operLog.setOperParam(StringUtils.substring(params, 0, 2000));
//        }
//    }
//
//    /**
//     * 参数拼装
//     */
//    /**
//     * 参数拼装.
//     * @param paramsArray 参数
//     * @return 结果
//     */
//    private String argsArrayToString(Object[] paramsArray) {
//
//        String params = "";
//        if (paramsArray != null && paramsArray.length > 0) {
//            for (Object o : paramsArray) {
//                if (ObjectUtils.isNotEmpty(o) && !isFilterObject(o)) {
//                    String jsonObj = JsonUtils.toString(o);
//                    params += jsonObj + " ";
//                }
//            }
//        }
//        return params.trim();
//    }
//
//    /**
//     * 判断是否需要过滤的对象.
//     *
//     * @param o 对象信息。
//     * @return 如果是需要过滤的对象，则返回true；否则返回false。
//     */
//    @SuppressWarnings("rawtypes")
//    public boolean isFilterObject(final Object o) {
//        Class<?> clazz = o.getClass();
//        if (clazz.isArray()) {
//            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
//        } else if (Collection.class.isAssignableFrom(clazz)) {
//            Collection collection = (Collection) o;
//            for (Object value : collection) {
//                return value instanceof MultipartFile;
//            }
//        } else if (Map.class.isAssignableFrom(clazz)) {
//            Map map = (Map) o;
//            for (Object value : map.entrySet()) {
//                Map.Entry entry = (Map.Entry) value;
//                return entry.getValue() instanceof MultipartFile;
//            }
//        }
//        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse
//                || o instanceof BindingResult;
//    }
//}
