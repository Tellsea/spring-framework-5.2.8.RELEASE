package cn.tellsea.springbean.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
@Configuration
public class ScopeConfig {

	@Bean
	@Scope("prototype")
	public Student student() {
		return new Student();
	}
}
