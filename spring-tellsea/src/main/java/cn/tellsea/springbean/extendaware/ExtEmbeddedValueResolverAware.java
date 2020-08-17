package cn.tellsea.springbean.extendaware;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author Tellsea
 * @date 2020-8-17
 */
@Component
public class ExtEmbeddedValueResolverAware implements EmbeddedValueResolverAware {

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println("ExtEmbeddedValueResolverAware setEmbeddedValueResolver：" + resolver);
	}
}
