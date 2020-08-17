package cn.tellsea.springbean.extendpostprocessor;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tellsea
 * @date 2020-8-16
 */
@Configuration
public class ExtMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {

	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		//在bean实例化完毕后调用 可以用来修改merged BeanDefinition的一些properties 或者用来给后续回调中缓存一些meta信息使用
		//这个算是将merged BeanDefinition暴露出来的一个回调
	}

	@Override
	public void resetBeanDefinition(String beanName) {
		//通知已重新设置指定名称的Bean定义，这个是一个回调接口
	}
}
