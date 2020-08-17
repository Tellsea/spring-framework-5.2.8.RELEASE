package cn.tellsea.springbean.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Tellsea
 * @date 2020-8-10
 */
@ComponentScan("cn.tellsea.springbean.lifecycle")
public class LifecycleConfig {

	@Bean(initMethod = "myInit", destroyMethod = "myDestroy")
	public PersonBean personBean() {
		PersonBean personBean = new PersonBean();
		personBean.setName("Tellsea");
		personBean.setAge(21);
		return personBean;
	}
}
