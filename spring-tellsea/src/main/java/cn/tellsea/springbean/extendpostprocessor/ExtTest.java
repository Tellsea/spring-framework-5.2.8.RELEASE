package cn.tellsea.springbean.extendpostprocessor;

import cn.tellsea.springbean.extendaware.AllAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Tellsea
 * @date 2020-8-16
 */
public class ExtTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AllAware.class);
	}
}
