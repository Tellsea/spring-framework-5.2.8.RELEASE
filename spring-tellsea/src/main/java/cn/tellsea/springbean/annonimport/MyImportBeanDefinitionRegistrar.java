package cn.tellsea.springbean.annonimport;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean redDefinition = registry.containsBeanDefinition("cn.tellsea.springbean.annonimport.Red");
		boolean greenDefinition = registry.containsBeanDefinition("cn.tellsea.springbean.annonimport.Green");
		boolean yellowDefinition = registry.containsBeanDefinition("cn.tellsea.springbean.annonimport.Yellow");
		if (redDefinition && greenDefinition && yellowDefinition) {
			// 创建bean的定义信息
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Black.class);
			registry.registerBeanDefinition("black", rootBeanDefinition);
		}
	}
}
