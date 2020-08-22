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
public class PriorityOrderedTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(OrderedConfig.class);
		List<Object> list = new ArrayList<>();
		list.add(applicationContext.getBean(PriorityOrderedOne.class));
		list.add(applicationContext.getBean(PriorityOrderedTwo.class));
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
