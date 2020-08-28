package cn.tellsea.springbean.register;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class MyTypeFilter implements TypeFilter {

	/**
	 * @param metadataReader        当前正在扫描的类的信息
	 * @param metadataReaderFactory 获取到其他任何类的信息
	 * @return
	 * @throws IOException
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		// 获取到当前正在扫描的类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		String className = classMetadata.getClassName();
		System.out.println("自定义扫描规则加载类：" + className);
		if (className.contains("o")) {
			return true;
		}
		return false;
	}
}
