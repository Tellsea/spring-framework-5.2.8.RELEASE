package cn.tellsea.springbean.register;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class TestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
		// 输出结果：User{name='Tellsea', age=21}
	}
}
