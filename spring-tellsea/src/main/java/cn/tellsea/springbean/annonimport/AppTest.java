package cn.tellsea.springbean.annonimport;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
}
