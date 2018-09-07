/**
 * 
 */
package cn.lgx.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


//@Aspect
//@Component
public class TimeAspect {
	
//	@Around("execution(* cn.lgx.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		//ProceedingJoinPoint 包含被拦截处理的方法信息

		System.out.println("time aspect start");
		
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("arg is "+arg);
		}
		
		long start = System.currentTimeMillis();

		 //被拦截的对象
		Object object = pjp.proceed();
		
		System.out.println("time aspect 耗时:"+ (System.currentTimeMillis() - start));
		
		System.out.println("time aspect end");
		
		return object;
	}

}
