/**
 * 
 */
package cn.lgx.security.core.validate.code.config;

import cn.lgx.security.core.properties.SecurityProperties;
import cn.lgx.security.core.validate.code.ValidateCodeGenerator;
import cn.lgx.security.core.validate.code.image.ImageCodeGenerator;
import cn.lgx.security.core.validate.code.sms.DefaultSmsCodeSender;
import cn.lgx.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 可配置类
 *
 */

@Configuration
public class ValidateCodeBeanConfig {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Bean
	@ConditionalOnMissingBean(name = "imageCodeGenerator")		//找到该名字的bean，则不执行下面的代码
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}
	
	@Bean
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}

}
