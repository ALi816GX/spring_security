package cn.lgx.security.core.validate.code.config.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public class SmsCodeAuthenticationProvider implements AuthenticationProvider {


    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthencticationToken smsCodeAuthencticationToken = (SmsCodeAuthencticationToken) authentication;
        UserDetails user = userDetailsService.loadUserByUsername((String) smsCodeAuthencticationToken.getPrincipal());       //token的用户信息

        if(user == null){
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }

        SmsCodeAuthencticationToken authencticationResult = new SmsCodeAuthencticationToken(user,user.getAuthorities());

        authencticationResult.setDetails(authentication.getDetails());

        return authencticationResult;
    }


    //支持对应的AuthencticationToken
    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthencticationToken.class.isAssignableFrom(authentication);
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
