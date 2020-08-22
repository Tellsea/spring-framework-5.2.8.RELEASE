/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 排序规则：
 * 1、PriorityOrdered优先级最高
 * 2、具有相同顺序值的对象按任意顺序排序
 * 3、无序对象都是隐式的，分配的值为最大值，在排序的末尾
 *
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @see Ordered
 * @see PriorityOrdered
 * @see org.springframework.core.annotation.AnnotationAwareOrderComparator
 * @see java.util.List#sort(java.util.Comparator)
 * @see java.util.Arrays#sort(Object[], java.util.Comparator)
 * @since 07.04.2003
 */
public class OrderComparator implements Comparator<Object> {

	/**
	 * {@code OrderComparator}的共享默认实例。
	 */
	public static final OrderComparator INSTANCE = new OrderComparator();


	/**
	 * 与给定的源提供商建立一个适应的order比较器。
	 *
	 * @param sourceProvider order源提供程序
	 * @return 自适应比较器
	 * @since 4.1
	 */
	public Comparator<Object> withSourceProvider(OrderSourceProvider sourceProvider) {
		return (o1, o2) -> doCompare(o1, o2, sourceProvider);
	}

	@Override
	public int compare(@Nullable Object o1, @Nullable Object o2) {
		return doCompare(o1, o2, null);
	}

	private int doCompare(@Nullable Object o1, @Nullable Object o2, @Nullable OrderSourceProvider sourceProvider) {
		// 如果有PriorityOrdered 接口的，则 PriorityOrdered 优先级比其他的都高
		boolean p1 = (o1 instanceof PriorityOrdered);
		boolean p2 = (o2 instanceof PriorityOrdered);
		if (p1 && !p2) {
			return -1;
		} else if (p2 && !p1) {
			return 1;
		}
		// 如果都是PriorityOrdered 通过order值排序，值小优先级高
		// 如果都不是PriorityOrdered，即是其他的接口和注解，通过order值来排序，值越小优先级越高
		int i1 = getOrder(o1, sourceProvider);
		int i2 = getOrder(o2, sourceProvider);
		return Integer.compare(i1, i2);
	}

	/**
	 * 确定给定对象的order值。
	 * 默认实现检查给定的{@link OrderSourceProvider}
	 * 使用{@link #findOrder}并返回到常规的{@link#getOrder（Object）}调用。
	 *
	 * @param obj 要检查的对象
	 * @return 排序值, 或 {@code Ordered.LOWEST_PRECEDENCE} 默认值
	 */
	private int getOrder(@Nullable Object obj, @Nullable OrderSourceProvider sourceProvider) {
		Integer order = null;
		if (obj != null && sourceProvider != null) {
			Object orderSource = sourceProvider.getOrderSource(obj);
			if (orderSource != null) {
				if (orderSource.getClass().isArray()) {
					Object[] sources = ObjectUtils.toObjectArray(orderSource);
					for (Object source : sources) {
						order = findOrder(source);
						if (order != null) {
							break;
						}
					}
				} else {
					order = findOrder(orderSource);
				}
			}
		}
		return (order != null ? order : getOrder(obj));
	}

	/**
	 * 确定给定对象的排序值.
	 * <p>默认实现检查{@link Ordered}接口
	 * 通过委派给{@link #findOrder}。可以在子类中重写。
	 *
	 * @param obj 要检查的对象
	 * @return 排序值, 或 {@code Ordered.LOWEST_PRECEDENCE} 默认值
	 */
	protected int getOrder(@Nullable Object obj) {
		if (obj != null) {
			Integer order = findOrder(obj);
			if (order != null) {
				return order;
			}
		}
		return Ordered.LOWEST_PRECEDENCE;
	}

	/**
	 * 查找给定对象指示的排序值.
	 * <p>默认实现检查{@link Ordered}接口。
	 * 可以在子类中重写。
	 *
	 * @param obj 要检查的对象
	 * @return 排序值, 或 {@code Ordered.LOWEST_PRECEDENCE} 默认值
	 */
	@Nullable
	protected Integer findOrder(Object obj) {
		return (obj instanceof Ordered ? ((Ordered) obj).getOrder() : null);
	}

	/**
	 * 确定给定对象的优先级值（如果有）。
	 * <p>默认实现始终返回{@code null}。
	 * 子类可以重写它以给特定类型的值
	 * 除了'priority'的语义。
	 * 优先级表示它可以用来选择一个对象
	 * 另一个，除了在列表/数组中用于排序之外。
	 *
	 * @param obj 要检查的对象
	 * @return 优先级值，如果没有，则为{@code null}
	 * @since 4.1
	 */
	@Nullable
	public Integer getPriority(Object obj) {
		return null;
	}


	/**
	 * 使用默认OrderComparator对给定列表排序。
	 * <p>优化为跳过大小为0或1的列表的排序，
	 * 为了避免不必要的数组提取。
	 *
	 * @param list the List to sort
	 * @see java.util.List#sort(java.util.Comparator)
	 */
	public static void sort(List<?> list) {
		if (list.size() > 1) {
			list.sort(INSTANCE);
		}
	}

	/**
	 * 使用默认OrderComparator对给定数组进行排序。
	 * <p>优化以跳过对大小为0或1的列表的排序,
	 * 为了避免不必要的数组提取。
	 *
	 * @param array 要排序的数组
	 * @see java.util.Arrays#sort(Object[], java.util.Comparator)
	 */
	public static void sort(Object[] array) {
		if (array.length > 1) {
			Arrays.sort(array, INSTANCE);
		}
	}

	/**
	 * 使用默认的OrderComparator对给定的数组或列表进行排序,
	 * 如果有必要. 给定其他任何值时，仅跳过排序.
	 * <p>优化以跳过对大小为0或0的列表的排序1,
	 * 为了避免不必要的数组提取.
	 *
	 * @param value 数组或要排序的列表
	 * @see java.util.Arrays#sort(Object[], java.util.Comparator)
	 */
	public static void sortIfNecessary(Object value) {
		if (value instanceof Object[]) {
			sort((Object[]) value);
		} else if (value instanceof List) {
			sort((List<?>) value);
		}
	}


	/**
	 * 策略接口，用于为给定对象提供order来源。
	 *
	 * @since 4.1
	 */
	@FunctionalInterface
	public interface OrderSourceProvider {

		/**
		 * 返回指定对象的order来源，即
		 * 应检查order值以代替给定对象。
		 * <p>也可以是订order源对象的数组。
		 * <p>如果返回的对象不表示任何顺序，则比较器
		 * 将退回到检查原始对象。
		 *
		 * @param obj 查找order来源的对象
		 * @return 该对象的order来源，如果找不到，则为{@code null}
		 */
		@Nullable
		Object getOrderSource(Object obj);
	}

}
