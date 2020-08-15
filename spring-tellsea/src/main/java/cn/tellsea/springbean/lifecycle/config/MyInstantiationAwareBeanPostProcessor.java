package cn.tellsea.springbean.lifecycle.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyDescriptor;

/**
 * 一般情况下，当我们需要实现InstantiationAwareBeanPostProcessor接口时，是通过继承Spring框架中InstantiationAwareBeanPostProcessor接口实现类
 * InstantiationAwareBeanPostProcessorAdapter这个适配器类来简化我们实现接口的工作
 *
 * @author Tellsea
 * @date 2020-8-14
 */
@Configuration
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	public MyInstantiationAwareBeanPostProcessor() {
		System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor构造方法");
	}

	/**
	 * 实例化Bean之前调用
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
		System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessBeforeInstantiation方法");
		return null;
	}

	/**
	 * 实例化Bean之后调用
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessAfterInitialization方法");
		return bean;
	}

	/**
	 * 设置某个属性时调用
	 */
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		System.out.println("【InstantiationAwareBeanPostProcessor接口】调用InstantiationAwareBeanPostProcessor接口的postProcessPropertyValues方法");
		return pvs;
	}
}
