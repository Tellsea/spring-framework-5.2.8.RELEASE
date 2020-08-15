package cn.tellsea.springbean.lifecycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Tellsea
 * @date 2020-8-10
 */
@ComponentScan("cn.tellsea")
public class AppConfig {

	@Bean(initMethod = "myInit", destroyMethod = "myDestroy")
	public PersonBean personBean() {
		PersonBean personBean = new PersonBean();
		personBean.setName("Tellsea");
		personBean.setAge(21);
		return personBean;
	}
}
