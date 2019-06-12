package com.springlearn.aop.impl;

import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 把这个类声明为一个切面：
 * 1.将该类放入容器中
 * 2.再声明为一个切面
 * @author EverAfter
 *
 */
/**
 * 使用@Order来声明通知顺序
 * @author EverAfter
 *
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * 定义一个方法，用于声明切入表达式。一般地，该方法中不需要填入其它代码
	 * 使用@Pointcut来声明切入点表达式
	 * 后面的其它通知直接使用方法名来引用当前的切入点表达式
	 */
	@Pointcut("execution(* com.springlearn.aop.impl.*.*(int,int))")
	public void declareJoinPointExpression() {}
	/**
	 * 声明该方法为一个前置通知；在目标方法开始之前执行
	 * @param joinPoint
	*/
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with "+ args);
	}
	
	/**
	 * 后置通知：在目标方法执行后（无论是否发生异常），执行的通知
	 * 在后置通知中还不能访问方法执行的结果
	 * @param joinPoint
	 */
	
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	/**
	 * 返回通知：在方法正常结束后执行的代码
	 * 返回通知可以访问到方法的返回值
	 * @param joinPoint
	 * @param result
	 */

	@AfterReturning(value="declareJoinPointExpression()",returning = "result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+result);
	}
	
	/**
	 * 异常通知：在方法出现异常时执行的代码
	 * 可以访问到异常对象，且可以指定出现特定异常时执行通知代码
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value="declareJoinPointExpression()",throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occur exception "+ex);
	}
	/**
	 * 环绕通知需要携带ProceedingJoinPoint 类型的参数
	 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以设定是否执行目标方法
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 */
	@Around("declareJoinPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd) {
		Object result=null;
		String methodName = pjd.getSignature().getName();
		//执行目标方法
		try {
			//前置通知
			System.out.println("The method "+ methodName+" begins1 with "+ Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			//返回通知
			System.out.println("The method "+ methodName+" ends1 with "+ result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method "+ methodName+" occur1 exception "+ e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The method "+ methodName+" ends1");
		
		return result;
	}
	
	
}
