package cn.tellsea.springbean.annonimport;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
@Import({Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
@ComponentScan("cn.tellsea.springbean.annonimport")
public class AppConfig {
}
