package cn.tellsea.test;

import cn.tellsea.config.AppConfig;
import cn.tellsea.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tellsea
 * @date 2020-8-10
 */
public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IndexService indexService = applicationContext.getBean(IndexService.class);
		System.out.println(indexService);
	}
}
