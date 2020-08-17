package cn.tellsea.springbean.extendaware;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Tellsea
 * @date 2020-8-17
 */
@Component
public class ExtEnvironmentAware implements EnvironmentAware {

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("EnvironmentAware setEnvironment：" + environment);
	}
}
