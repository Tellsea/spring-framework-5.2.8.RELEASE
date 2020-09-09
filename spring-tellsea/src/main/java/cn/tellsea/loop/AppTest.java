package cn.tellsea.loop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tellsea
 * @date 2020-9-2
 */
public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		applicationContext.getBean(IndexService.class).testProxy();
	}
}
