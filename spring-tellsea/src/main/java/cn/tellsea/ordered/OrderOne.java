package cn.tellsea.ordered;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author Tellsea
 * @date 2020-8-19
 */
@Order(Ordered.LOWEST_PRECEDENCE)
@Configuration
public class OrderOne {

}
