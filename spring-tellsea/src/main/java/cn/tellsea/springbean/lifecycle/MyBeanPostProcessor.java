package cn.tellsea.springbean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tellsea
 * @date 2020-8-14
 */
@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {
		System.out.println("【BeanPostProcessor接口】调用BeanPostProcessor的构造方法");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("【BeanPostProcessor接口】调用postProcessBeforeInitialization方法，这里可对" + beanName + "的属性进行更改。");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("【BeanPostProcessor接口】调用postProcessAfterInitialization方法，这里可对" + beanName + "的属性进行更改。");
		return bean;
	}
}
