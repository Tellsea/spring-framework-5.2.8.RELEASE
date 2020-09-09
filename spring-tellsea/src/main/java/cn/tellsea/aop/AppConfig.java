package cn.tellsea.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Tellsea
 * @date 2020-9-9
 */
@ComponentScan("cn.tellsea.aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
