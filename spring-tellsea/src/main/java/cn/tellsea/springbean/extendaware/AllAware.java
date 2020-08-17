package cn.tellsea.springbean.extendaware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.util.StringValueResolver;

/**
 * @author Tellsea
 * @date 2020-8-17
 */
@Configuration
public class AllAware implements
		BeanNameAware,
		BeanClassLoaderAware,
		BeanFactoryAware,

		EnvironmentAware,
		EmbeddedValueResolverAware,
		ResourceLoaderAware,
		ApplicationEventPublisherAware,
		MessageSourceAware,
		ApplicationContextAware,

		// ServletContextAware,
		LoadTimeWeaverAware,
		ImportAware {

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware setBeanName ...");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("BeanClassLoaderAware setBeanClassLoader ...");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactoryAware setBeanFactory ...");
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("EnvironmentAware setEnvironment ...");
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println("EmbeddedValueResolverAware setEmbeddedValueResolver ...");
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("ResourceLoaderAware setResourceLoader ...");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("ApplicationEventPublisherAware setApplicationEventPublisher ...");
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("MessageSourceAware setMessageSource ...");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware setApplicationContext ...");
	}

	@Override
	public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
		System.out.println("LoadTimeWeaverAware setLoadTimeWeaver ...");
	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		System.out.println("ImportAware setImportMetadata ...");
	}
}
