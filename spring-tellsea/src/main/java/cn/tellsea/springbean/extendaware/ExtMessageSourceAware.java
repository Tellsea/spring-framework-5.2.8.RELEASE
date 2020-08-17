package cn.tellsea.springbean.extendaware;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * @author Tellsea
 * @date 2020-8-17
 */
@Component
public class ExtMessageSourceAware implements MessageSourceAware {

	protected MessageSourceAccessor messageSourceAccessor;

	public ExtMessageSourceAware() {
		System.out.println("无参构造");
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
	}
}
