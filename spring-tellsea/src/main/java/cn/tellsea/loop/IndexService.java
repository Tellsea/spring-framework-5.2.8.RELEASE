package cn.tellsea.loop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Tellsea
 * @date 2020-9-2
 */
@Component
public class IndexService implements ApplicationContextAware {

	@Autowired
	private UserService userService;

	public IndexService() {
		System.out.println("IndexService Constructor ...");
	}

	public void testProxy() {
		System.out.println("自定义代理方法 ....");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("applicationContext: " + applicationContext);
	}
}
