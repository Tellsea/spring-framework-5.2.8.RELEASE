package cn.tellsea.springbean.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
@ComponentScan("cn.tellsea.springbean.conditional")
@Conditional({LinuxCondition.class})
public class AppConfig {

	@Bean
	@Conditional({WindowsCondition.class})
	public WindowsUser windowsUser() {
		return new WindowsUser();
	}

	@Bean
	@Conditional({LinuxCondition.class})
	public LinuxUser linuxUser() {
		return new LinuxUser();
	}
}
