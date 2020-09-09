package cn.tellsea.loop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Tellsea
 * @date 2020-9-2
 *
 * proxyTargetClass: 强制使用CGLIB代理，默认jdk代理
 */
@ComponentScan("cn.tellsea.loop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
