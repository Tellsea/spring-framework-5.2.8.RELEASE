package cn.tellsea.springbean.extendaware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Tellsea
 * @date 2020-8-17
 */
@Component
public class ExtApplicationContextAware implements ApplicationContextAware {

	// 当前上下文
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
