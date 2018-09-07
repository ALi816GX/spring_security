/**
 * 
 */
package cn.lgx.security.core.validate.code.image;

import cn.lgx.security.core.validate.code.sms.SmsCodeProperties;


public class  ImageCodeProperties extends SmsCodeProperties {
	
	public ImageCodeProperties() {
		setLength(4);
	}
	 
	private int width = 67;
	private int height = 25;


	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}


}