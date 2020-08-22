package cn.tellsea.ordered;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.OrderComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tellsea
 * @date 2020-8-19
 */
public class OrderTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(OrderedConfig.class);
		List<Object> list = new ArrayList<>();
		list.add(applicationContext.getBean(OrderOne.class));
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
