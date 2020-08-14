package cn.tellsea.Beanlifecycle.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Tellsea
 * @date 2020-8-14
 */
public class PersonBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
		InitializingBean, DisposableBean {

	private String name;
	private int age;

	/**
	 * 实现了BeanNameAware接口，Spring可以将BeanName注入该属性中
	 */
	private String beanName;
	/**
	 * 实现了BeanFactory接口，Spring可将BeanFactory注入该属性中
	 */
	private BeanFactory beanFactory;
	/**
	 * 实现了ApplicationContextAware接口，Spring可将ApplicationContext注入该属性中
	 */
	private ApplicationContext applicationContext;


	public PersonBean() {
		System.out.println("【Bean构造方法】Person类的无参构造方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("【set注入】注入学生的name属性");
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("【set注入】注入学生的age属性");
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonBean{" +
				"name='" + name + '\'' +
				", age=" + age +
				", beanName='" + beanName + '\'' +
				", beanFactory=" + beanFactory +
				", applicationContext=" + applicationContext +
				'}';
	}

	public void myInit() {
		System.out.println("【init-method】调用init-method属性配置的初始化方法");
	}

	public void myDestroy() {
		System.out.println("【destroy-method】调用destroy-method属性配置的销毁方法");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware的setBeanFactory方法得到beanFactory引用");
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("【BeanNameAware接口】调用BeanNameAware的setBeanName方法得到Bean的名称");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("【ApplicationContextAware接口】调用ApplicationContextAware的setApplicationContext方法得到applicationContext：{" + applicationContext + "}");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("【InitializingBean接口】调用InitializingBean接口的afterPropertiesSet方法");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("【DisposableBean接口】调用DisposableBean接口的destroy方法");
	}
}
