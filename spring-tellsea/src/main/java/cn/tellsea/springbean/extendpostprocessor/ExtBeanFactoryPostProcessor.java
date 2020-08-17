package cn.tellsea.springbean.extendpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tellsea
 * @date 2020-8-14
 */
@Configuration
public class ExtBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//spring的bean创建之前，修改bean的定义属性
		System.out.println("【BeanFactoryPostProcessor接口】调用BeanFactoryPostProcessor接口的postProcessBeanFactory方法");
//		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("personBean");
//		beanDefinition.getPropertyValues().addPropertyValue("age", "22");
	}
}
