package cn.tellsea.springbean.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		System.out.println("FactoryBean User ...");
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
