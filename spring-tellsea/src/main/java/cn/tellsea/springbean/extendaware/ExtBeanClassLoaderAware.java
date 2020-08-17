package cn.tellsea.springbean.extendaware;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

/**
 * @author Tellsea
 * @date 2020-8-17
 */
@Component
public class ExtBeanClassLoaderAware implements BeanClassLoaderAware {

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("BeanClassLoaderAware setBeanClassLoader：" + classLoader);
	}
}
