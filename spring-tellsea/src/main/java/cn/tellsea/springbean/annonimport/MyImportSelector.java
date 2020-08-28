package cn.tellsea.springbean.annonimport;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Tellsea
 * @date 2020-8-28
 */
public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"cn.tellsea.springbean.annonimport.Green", "cn.tellsea.springbean.annonimport.Yellow"};
	}
}
