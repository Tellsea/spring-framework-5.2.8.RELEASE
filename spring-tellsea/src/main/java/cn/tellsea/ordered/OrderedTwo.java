package cn.tellsea.ordered;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author Tellsea
 * @date 2020-8-18
 */
@Configuration
public class OrderedTwo implements Ordered {

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}
}
