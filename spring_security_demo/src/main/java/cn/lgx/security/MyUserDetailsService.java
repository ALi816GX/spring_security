package cn.lgx.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;


@Component
public class MyUserDetailsService implements UserDetailsService,SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    //注入dao层或者mapper对象
//    @Autowired

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("表单登录用户名"+username);
        return buildUser(username);

    }


    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("社交登录名用户id"+userId);
        return buildUser(userId);
    }


    private SocialUserDetails buildUser(String type){
        //根据用户向数据库查找信息(从数据库读取)

        //根据查找到的用户信息判断用户是否被冻结

        String password = passwordEncoder.encode("123456");

        logger.info("数据库的加密密码是"+password);

        //返回对象需要实现UserDetails接口, 然后实现逻辑写在对应的四个接口中
        return new SocialUser(type,password,
                true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }


}
