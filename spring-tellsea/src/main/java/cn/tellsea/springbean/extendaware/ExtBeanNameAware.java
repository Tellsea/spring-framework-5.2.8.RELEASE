package cn.tellsea.springbean.extendaware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author Tellsea
 * @date 2020-8-16
 */
@Component
public class ExtBeanNameAware implements BeanNameAware {

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware setBeanName：" + name);
	}
}
