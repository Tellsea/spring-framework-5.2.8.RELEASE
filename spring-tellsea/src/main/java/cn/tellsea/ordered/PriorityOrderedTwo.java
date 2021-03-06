package cn.tellsea.ordered;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * @author Tellsea
 * @date 2020-8-18
 */
@Configuration
public class PriorityOrderedTwo implements PriorityOrdered {

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}
}
