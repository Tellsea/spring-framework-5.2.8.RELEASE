package cn.tellsea.springbean.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class FactoryBeanTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
		System.out.println("----------------------------------");
		Object userFactoryBean = applicationContext.getBean("userFactoryBean");
		System.out.println("UserFactoryBean 的类型：" + userFactoryBean.getClass());
		Object userFactoryBean2 = applicationContext.getBean("&userFactoryBean");
		System.out.println("UserFactoryBean 的类型：" + userFactoryBean2.getClass());
	}
}
