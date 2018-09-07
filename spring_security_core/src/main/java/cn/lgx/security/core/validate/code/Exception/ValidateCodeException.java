/**
 * 
 */
package cn.lgx.security.core.validate.code.Exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 抽象异常 身份验证抛出异常的基类
 */
public class ValidateCodeException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7285211528095468156L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
