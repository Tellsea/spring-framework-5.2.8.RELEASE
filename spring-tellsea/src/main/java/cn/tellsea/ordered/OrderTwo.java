package cn.tellsea.ordered;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author Tellsea
 * @date 2020-8-19
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class OrderTwo {

}
