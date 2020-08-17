package cn.tellsea.springbean.extendpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tellsea
 * @date 2020-8-15
 */
@Configuration
public class ExtBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//该方法在bean实例化完毕（且已经注入完毕），在afterPropertiesSet或自定义init方法执行之前
		System.out.println("BeanPostProcessor postProcessBeforeInitialization ...");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//在afterPropertiesSet或自定义init方法执行之后
		System.out.println("InstantiationAwareBeanPostProcessor postProcessAfterInitialization ...");
		return null;
	}
}
