package cn.tellsea.springbean.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class LinuxCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 能获取当前环境的信息
		Environment environment = context.getEnvironment();
		// 获取操作系统
		String property = environment.getProperty("os.name");
		if (property.contains("linux")) {
			return true;
		}
		return false;
	}
}
