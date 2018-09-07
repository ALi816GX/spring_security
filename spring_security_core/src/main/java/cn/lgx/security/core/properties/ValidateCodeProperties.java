/**
 * 
 */
package cn.lgx.security.core.properties;

import cn.lgx.security.core.validate.code.image.ImageCodeProperties;
import cn.lgx.security.core.validate.code.sms.SmsCodeProperties;



public class ValidateCodeProperties {
	
	private ImageCodeProperties image = new ImageCodeProperties();
	
	private SmsCodeProperties sms = new SmsCodeProperties();
//
	public ImageCodeProperties getImage() {
		return image;
	}

	public void setImage(ImageCodeProperties image) {
		this.image = image;
	}
//
	public SmsCodeProperties getSms() {
		return sms;
	}

	public void setSms(SmsCodeProperties sms) {
		this.sms = sms;
	}
	
}
