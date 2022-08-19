package com.atqgh.common.beanpossor;//package com.atqgh.common.beanpossor;
//
//import com.atqgh.common.anno.FeignResultHandler;
//import com.atqgh.common.config.beanfactory.MyFeignClientFactoryBean;
//import org.apache.commons.lang3.ObjectUtils;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.cloud.openfeign.FeignClientFactoryBean;
//import org.springframework.core.PriorityOrdered;
//
///**
// * 因为FeignClientFactoryBean在创建bean的后置处理器时，有一个实现了Order接口的后置处理器对该bean定义的
// * 后置处理器已经创建了bean，所以我们直接实现BeanPostProcessor不能对FeignClientFactoryBean进行拦截，
// * 故我们需要在这个后置处理器之前创建一个后置处理器
// * bean的后置处理器，用于对FeignClientFactoryBean的处理.
// *
// * @author Mubai
// * @since 2022/8/13 10:16 上午
// **/
//public class MyFeignClientBeanProcessor implements BeanPostProcessor, PriorityOrdered {
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//
//        if (bean instanceof FeignClientFactoryBean) {
//            FeignClientFactoryBean feignClientFactoryBean = (FeignClientFactoryBean) bean;
//            Class<?> objectType = feignClientFactoryBean.getObjectType();
//            if (ObjectUtils.isNotEmpty(objectType)
//                    && ObjectUtils.isNotEmpty(objectType.getAnnotation(FeignResultHandler.class))) {
//                return new MyFeignClientFactoryBean(feignClientFactoryBean, objectType.getAnnotation(FeignResultHandler.class));
//            }
//        }
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
//    }
//
//    @Override
//    public int getOrder() {
//        return 1;
//    }
//
//}
