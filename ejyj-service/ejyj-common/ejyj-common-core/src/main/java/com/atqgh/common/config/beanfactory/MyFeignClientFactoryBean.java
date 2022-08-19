package com.atqgh.common.config.beanfactory;//package com.atqgh.common.config.beanfactory;
//
//import com.atqgh.common.anno.FeignResultHandler;
//import java.lang.reflect.Proxy;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.FactoryBean;
//import org.springframework.cloud.openfeign.FeignClientFactoryBean;
//
///**
// * feignClientFactoryBean.
// * @author Mubai
// * @since 2022/8/6 9:19 上午
// **/
//@AllArgsConstructor
//public class MyFeignClientFactoryBean implements FactoryBean<Object> {
//
//    private final FeignClientFactoryBean feignClientFactoryBean;
//
//    private final FeignResultHandler annotation;
//
//    @Override
//    public Object getObject() {
//
//        // 生成一个代理对象，用于对feignClient调用之后的结果进行处理
//        Object object = feignClientFactoryBean.getObject();
//        FeignClientHandler feignClientHandler = new FeignClientHandler(object, annotation);
//        assert object != null;
//        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
//                object.getClass().getInterfaces(),
//                feignClientHandler);
//    }
//
//    @Override
//    public Class<?> getObjectType() {
//        return feignClientFactoryBean.getObjectType();
//    }
//}
