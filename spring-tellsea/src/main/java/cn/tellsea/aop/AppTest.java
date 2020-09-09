package cn.tellsea.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tellsea
 * @date 2020-9-9
 */
public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MathService mathService = applicationContext.getBean(MathService.class);
		Integer result = mathService.calculation(100, 100);
		System.out.println(result);
	}
}
