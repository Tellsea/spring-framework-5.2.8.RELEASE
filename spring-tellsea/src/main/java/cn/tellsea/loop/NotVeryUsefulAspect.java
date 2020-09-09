package cn.tellsea.loop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 自定义aop
 *
 * @author Tellsea
 * @date 2020-9-8
 */
@Aspect
@Component
public class NotVeryUsefulAspect {

	@Pointcut("within(cn.tellsea.loop.IndexService)")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void doAccessCheck() {
		System.out.println("前置通知 ...");
	}
}
