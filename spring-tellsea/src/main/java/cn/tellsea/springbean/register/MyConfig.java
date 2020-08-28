package cn.tellsea.springbean.register;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
@Configuration
@ComponentScan(value = "cn.tellsea.springbean.register",
		excludeFilters = {
				@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
				@Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
		})
public class MyConfig {

	@Bean
	public User user() {
		User user = new User();
		user.setName("Tellsea");
		user.setAge(21);
		return user;
	}
}
