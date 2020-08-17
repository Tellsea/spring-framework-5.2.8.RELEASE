package cn.tellsea.springbean.extendpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tellsea
 * @date 2020-8-16
 */
@Configuration
public class ExtDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		//这里实现销毁对象的逻辑
	}

	@Override
	public boolean requiresDestruction(Object bean) {
		//判断是否需要处理这个对象的销毁
		return false;
	}
}
