package cn.tellsea.loop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Tellsea
 * @date 2020-9-2
 */
@Component
public class UserService {

	@Autowired
	private IndexService indexService;

	public UserService() {
		System.out.println("UserService Constructor ...");
	}
}
