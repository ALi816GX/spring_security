package cn.lgx.security.core.properties;
import org.springframework.boot.context.properties.ConfigurationProperties;




@ConfigurationProperties(prefix = "cn.lgx")
public class BrowserProperties {

	private String loginPage = "/imooc-signIn.html";

	private LoginType loginType = LoginType.JSON;		//登录类型（json,跳转）

	private int rememberMeSeconds = 3600;

	//	private SessionProperties session = new SessionProperties();
//
//	private String signUpUrl = "/imooc-signUp.html";
//
//	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
//
//	private LoginResponseType loginType = LoginResponseType.JSON;
//



	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}


	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
//
//	public String getSignUpUrl() {
//		return signUpUrl;
//	}
//
//	public void setSignUpUrl(String signUpUrl) {
//		this.signUpUrl = signUpUrl;
//	}
//
//	public SessionProperties getSession() {
//		return session;
//	}
//
//	public void setSession(SessionProperties session) {
//		this.session = session;
//	}
	
}
