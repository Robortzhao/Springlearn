package com.springlearn.transaction.xml;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springlearn.transaction.xml.service.BookShopService;
import com.springlearn.transaction.xml.service.Cashier;

public class SpringTransactionTest {
	
	private ApplicationContext ctx=null;
	private BookShopDao bookShopDao =null;
	private BookShopService bookShopService=null;
	private Cashier cashier=null;
	{
		ctx= new ClassPathXmlApplicationContext("spring-transaction-xml.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testBookShopService() {
		bookShopService.purchase("AA", "1001");
	}
	
	@Test
	public void testTransactionlPropagation() {
		cashier.checkout("AA", Arrays.asList("1001","1002"));
	}
}
