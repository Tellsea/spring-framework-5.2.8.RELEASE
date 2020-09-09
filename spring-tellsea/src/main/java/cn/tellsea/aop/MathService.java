package cn.tellsea.aop;

import org.springframework.stereotype.Component;

/**
 * @author Tellsea
 * @date 2020-9-9
 */
@Component
public class MathService {

	public int calculation(int a, int b) {
		return a / b;
	}
}
