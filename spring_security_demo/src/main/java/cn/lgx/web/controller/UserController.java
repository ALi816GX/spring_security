/**
 * 
 */
package cn.lgx.web.controller;

import java.util.ArrayList;
import java.util.List;

import cn.lgx.dto.User;
import cn.lgx.dto.UserQueryCondition;
import cn.lgx.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
@RequestMapping("/user")
public class UserController{


	@GetMapping("/me")
	public Object getCurrentUser(@AuthenticationPrincipal UserDetails authentication){
//	public Object getCurrentUser(Authentication authentication){
		return authentication;
	}


	@PostMapping
	@ApiOperation(value = "创建用户")
	public User create(@Valid @RequestBody User user) {

//		if (errors.hasErrors()){
//			errors.getAllErrors().stream().forEach(error-> System.out.println(error.getDefaultMessage()));
//		}

		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());

		user.setId("1");
		return user;
	}


	@GetMapping
	//Pageable springdata 分页标签
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQueryCondition userQueryCondition,@PageableDefault(page = 2,size = 10,sort = "username,asc") Pageable pageable){

		System.out.println(userQueryCondition);

//		System.out.println(pageable.getPageSize());
//		System.out.println(pageable.getSort());
//		System.out.println(pageable.getPageNumber());

		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}


	//:后面加正泽表达式来过滤业务
//	@JsonView(User.UserDataDetailView.class)
	@GetMapping("/{id:\\d+}")
	public User getInfo(@PathVariable String id) {

//		throw new UserNotExistException(" user not exit");
//		throw new RuntimeException(" user not exit");

		System.out.println("进入getinfo服务");

		User user = new User();
		user.setUsername("tom");
		return user;
	}





	
//	@Autowired
//	private ProviderSignInUtils providerSignInUtils;
//
//	@PostMapping("/regist")
//	public void regist(User user, HttpServletRequest request) {
//
//		//不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
//		String userId = user.getUsername();
//		providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
//	}
//
//	@GetMapping("/me")
//	public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
//		return user;
//	}
//

//
	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user, BindingResult errors) {

		if (errors.hasErrors()){
			errors.getAllErrors().stream().forEach(error-> {

				FieldError fieldError = (FieldError)error;
				String message = fieldError.getField() +" "+ error.getDefaultMessage();
				System.out.println(message);

					});
		}

		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());

		user.setId("1");
		return user;
	}
//
	@DeleteMapping("/{id:\\d+}")
	public void delete(@ApiParam(value = "用户的id") @PathVariable String id) {
		System.out.println(id);
	}
//
//	@GetMapping
//	@JsonView(User.UserSimpleView.class)
//	@ApiOperation(value = "用户查询服务")
//	public List<User> query(UserQueryCondition condition,
//			@PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {
//
//		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
//
//		System.out.println(pageable.getPageSize());
//		System.out.println(pageable.getPageNumber());
//		System.out.println(pageable.getSort());
//
//		List<User> users = new ArrayList<>();
//		users.add(new User());
//		users.add(new User());
//		users.add(new User());
//		return users;
//	}
//
//	@GetMapping("/{id:\\d+}")
//	@JsonView(User.UserDetailView.class)
//	public User getInfo(@ApiParam("用户id") @PathVariable String id) {
////		throw new RuntimeException("user not exist");
//		System.out.println("进入getInfo服务");
//		User user = new User();
//		user.setUsername("tom");
//		return user;
//	}

}
