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
 * �����������Ϊһ�����棺
 * 1.���������������
 * 2.������Ϊһ������
 * @author EverAfter
 *
 */
/**
 * ʹ��@Order������֪ͨ˳��
 * @author EverAfter
 *
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * ����һ����������������������ʽ��һ��أ��÷����в���Ҫ������������
	 * ʹ��@Pointcut�������������ʽ
	 * ���������ֱ֪ͨ��ʹ�÷����������õ�ǰ���������ʽ
	 */
	@Pointcut("execution(* com.springlearn.aop.impl.*.*(int,int))")
	public void declareJoinPointExpression() {}
	/**
	 * �����÷���Ϊһ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	 * @param joinPoint
	*/
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+methodName+" begins with "+ args);
	}
	
	/**
	 * ����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣����ִ�е�֪ͨ
	 * �ں���֪ͨ�л����ܷ��ʷ���ִ�еĽ��
	 * @param joinPoint
	 */
	
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends");
	}
	
	/**
	 * ����֪ͨ���ڷ�������������ִ�еĴ���
	 * ����֪ͨ���Է��ʵ������ķ���ֵ
	 * @param joinPoint
	 * @param result
	 */

	@AfterReturning(value="declareJoinPointExpression()",returning = "result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" ends with "+result);
	}
	
	/**
	 * �쳣֪ͨ���ڷ��������쳣ʱִ�еĴ���
	 * ���Է��ʵ��쳣�����ҿ���ָ�������ض��쳣ʱִ��֪ͨ����
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value="declareJoinPointExpression()",throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName+" occur exception "+ex);
	}
	/**
	 * ����֪ͨ��ҪЯ��ProceedingJoinPoint ���͵Ĳ���
	 * ����֪ͨ�����ڶ�̬�����ȫ���̣�ProceedingJoinPoint ���͵Ĳ��������趨�Ƿ�ִ��Ŀ�귽��
	 * �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	 */
	@Around("declareJoinPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjd) {
		Object result=null;
		String methodName = pjd.getSignature().getName();
		//ִ��Ŀ�귽��
		try {
			//ǰ��֪ͨ
			System.out.println("The method "+ methodName+" begins1 with "+ Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			//����֪ͨ
			System.out.println("The method "+ methodName+" ends1 with "+ result);
		} catch (Throwable e) {
			//�쳣֪ͨ
			System.out.println("The method "+ methodName+" occur1 exception "+ e);
			throw new RuntimeException(e);
		}
		//����֪ͨ
		System.out.println("The method "+ methodName+" ends1");
		
		return result;
	}
	
	
}
