package cn.tellsea.loop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Tellsea
 * @date 2020-9-2
 */
@Component
public class IndexService {

	@Autowired
	private UserService userService;

	public IndexService() {
		System.out.println("IndexService Constructor ...");
	}
}
