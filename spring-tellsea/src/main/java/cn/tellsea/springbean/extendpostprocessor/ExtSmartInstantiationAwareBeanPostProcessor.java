package cn.tellsea.springbean.extendpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Constructor;

/**
 * @author Tellsea
 * @date 2020-8-16
 */
@Configuration
public class ExtSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	@Override
	public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
		//用来返回目标对象的类型（比如代理对象通过raw class获取proxy type 用于类型匹配）
		System.out.println("SmartInstantiationAwareBeanPostProcessor predictBeanType ...");
		return null;
	}

	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
		//这里提供一个拓展点用来解析获取用来实例化的构造器（比如未通过bean定义构造器以及参数的情况下，会根据这个回调来确定构造器）
		System.out.println("SmartInstantiationAwareBeanPostProcessor determineCandidateConstructors ...");
		// return new Constructor[0];
		return null;
	}

	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		//获取要提前暴露的bean的引用，用来支持单例对象的循环引用（一般是bean自身，如果是代理对象则需要取用代理引用）
		System.out.println("SmartInstantiationAwareBeanPostProcessor getEarlyBeanReference ...");
		return null;
	}
}
