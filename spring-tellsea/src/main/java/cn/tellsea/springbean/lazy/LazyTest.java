package cn.tellsea.springbean.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class LazyTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LazyConfig.class);
		System.out.println("spring 启动完成 ...");
		Student student = applicationContext.getBean(Student.class);
		System.out.println(student);
	}
}
