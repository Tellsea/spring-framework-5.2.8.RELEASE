package cn.tellsea.springbean.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class ScopeTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
		Student student = applicationContext.getBean(Student.class);
		Student student2 = applicationContext.getBean(Student.class);
		System.out.println(student);
		System.out.println(student2);
		System.out.println(student == student2);
	}
}
