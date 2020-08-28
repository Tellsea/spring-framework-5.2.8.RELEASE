package cn.tellsea.springbean.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
@Configuration
public class LazyConfig {

	@Lazy
	@Bean
	public Student student() {
		System.out.println("加载了bean ...");
		return new Student();
	}
}
