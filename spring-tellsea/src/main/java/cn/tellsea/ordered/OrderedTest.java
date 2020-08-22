package cn.tellsea.ordered;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.OrderComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 *
 * @author Tellsea
 * @date 2020-8-18
 */
public class OrderedTest {

	public static void main(String[] args) {
		// 创建IOC容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(OrderedConfig.class);
		List<Object> list = new ArrayList<>();
		list.add(applicationContext.getBean(OrderedOne.class));
		list.add(applicationContext.getBean(OrderedTwo.class));
		System.out.println("OrderComparator.sort ... 之前");
		for (Object obj : list) {
			System.out.println(obj);
		}
		OrderComparator.sort(list);
		System.out.println("OrderComparator.sort ... 之后");
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
}
