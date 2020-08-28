package cn.tellsea.springbean.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
@Configuration
public class FactoryBeanConfig {

	@Bean
	public UserFactoryBean userFactoryBean() {
		return new UserFactoryBean();
	}
}
