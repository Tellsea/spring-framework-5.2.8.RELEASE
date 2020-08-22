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

package org.springframework.core.annotation;

import org.springframework.core.DecoratingProxy;
import org.springframework.core.OrderComparator;
import org.springframework.core.annotation.MergedAnnotations.SearchStrategy;
import org.springframework.lang.Nullable;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.List;

/**
 * AnnotationAwareOrderComparator是支持spring的Ordered接口，以及@Order和java的@Priority的注解，
 * 他的顺序值由Ordered提供，实例重写静态定义的注释值（如果有）。
 *
 * @author Juergen Hoeller
 * @author Oliver Gierke
 * @author Stephane Nicoll
 * @see org.springframework.core.Ordered
 * @see org.springframework.core.annotation.Order
 * @see javax.annotation.Priority
 * @since 2.0.1
 */
public class AnnotationAwareOrderComparator extends OrderComparator {

	/**
	 * {@code AnnotationAwareOrderComparator}的共享默认实例。
	 */
	public static final AnnotationAwareOrderComparator INSTANCE = new AnnotationAwareOrderComparator();


	/**
	 * 此实现检查{@link Order@Order}或
	 * {@链接javax.annotation.Priority@优先权
	 * 元素，以及{@链接org.springframework.core.有序的}
	 * 检查超类。
	 */
	@Override
	@Nullable
	protected Integer findOrder(Object obj) {
		Integer order = super.findOrder(obj);
		if (order != null) {
			return order;
		}
		return findOrderFromAnnotation(obj);
	}

	@Nullable
	private Integer findOrderFromAnnotation(Object obj) {
		AnnotatedElement element = (obj instanceof AnnotatedElement ? (AnnotatedElement) obj : obj.getClass());
		MergedAnnotations annotations = MergedAnnotations.from(element, SearchStrategy.TYPE_HIERARCHY);
		Integer order = OrderUtils.getOrderFromAnnotations(element, annotations);
		if (order == null && obj instanceof DecoratingProxy) {
			return findOrderFromAnnotation(((DecoratingProxy) obj).getDecoratedClass());
		}
		return order;
	}

	/**
	 * 此实现检索@{@链接javax.annotation.Priority}
	 * 值，允许在常规的@{@link Order}上附加语义
	 * 注释：通常，在
	 * 多个匹配项，但只返回一个对象。
	 */
	@Override
	@Nullable
	public Integer getPriority(Object obj) {
		if (obj instanceof Class) {
			return OrderUtils.getPriority((Class<?>) obj);
		}
		Integer priority = OrderUtils.getPriority(obj.getClass());
		if (priority == null && obj instanceof DecoratingProxy) {
			return getPriority(((DecoratingProxy) obj).getDecoratedClass());
		}
		return priority;
	}


	/**
	 * 使用默认的{@link AnnotationAwareOrderComparator}对给定列表进行排序。
	 * <p>优化为跳过大小为0或1的列表的排序，
	 * 为了避免不必要的数组提取。
	 *
	 * @param list 要排序的列表
	 * @see java.util.List#sort(java.util.Comparator)
	 */
	public static void sort(List<?> list) {
		if (list.size() > 1) {
			list.sort(INSTANCE);
		}
	}

	/**
	 * 使用默认注释awareOrderComparator对给定数组进行排序。
	 * <p>优化为跳过大小为0或1的列表的排序，
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
	 * 使用默认注释awareOrderComparator对给定的数组或列表进行排序，
	 * 如有必要。当给定任何其他值时，只需跳过排序。
	 * <p>优化为跳过大小为0或1的列表的排序，
	 * 为了避免不必要的数组提取。
	 *
	 * @param value 要排序的数组或列表
	 * @see java.util.Arrays#sort(Object[], java.util.Comparator)
	 */
	public static void sortIfNecessary(Object value) {
		if (value instanceof Object[]) {
			sort((Object[]) value);
		} else if (value instanceof List) {
			sort((List<?>) value);
		}
	}
}
