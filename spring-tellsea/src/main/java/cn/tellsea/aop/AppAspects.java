package cn.tellsea.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义切面
 *
 * @author Tellsea
 * @date 2020-9-9
 */
@Aspect
@Component
public class AppAspects {

	// 定义切入点
	@Pointcut("execution(* cn.tellsea.aop.MathService.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		System.out.println("运行之前通知 ...");
	}

	@After("pointCut()")
	public void after(JoinPoint joinPoint) {
		System.out.println("运行之后通知 ...");
	}

	@AfterReturning(value = "pointCut()", returning = "result")
	public void afterReturning(Object result) {
		System.out.println("通知之后(最后) ...");
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		System.out.println("抛出异常通知 ...");
	}
}
