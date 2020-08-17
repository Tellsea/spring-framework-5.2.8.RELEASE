package cn.tellsea.springbean.extendpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tellsea
 * @date 2020-8-16
 */
@Configuration
public class ExtInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		//这个方法用来在对象实例化前直接返回一个对象（如代理对象）来代替通过内置的实例化流程创建对象
		System.out.println("InstantiationAwareBeanPostProcessor postProcessBeforeInstantiation ...");
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		//在对象实例化完毕执行populateBean之前 如果返回false则spring不再对对应的bean实例进行自动依赖注入
		System.out.println("InstantiationAwareBeanPostProcessor postProcessAfterInstantiation ...");
		return false;
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		//这里是在spring处理完默认的成员属性，应用到指定的bean之前进行回调，可以用来检查和修改属性，最终返回的PropertyValues会应用到bean中
		//@Autowired、@Resource等就是根据这个回调来实现最终注入依赖的属性的
		System.out.println("InstantiationAwareBeanPostProcessor postProcessProperties ...");
		return null;
	}
}
