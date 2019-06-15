package com.springlearn.hibernate.test;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springlearn.hibernate.dao.BookShopDao;
import com.springlearn.hibernate.service.BookShopService;
import com.springlearn.hibernate.service.Cashier;

public class SpringHibernateTest {
	
	private ApplicationContext ctx=null;
    private BookShopService bookShopService= null;
    private BookShopDao bookShopDao=null;
    private Cashier cashier=null;
	{
		ctx=new ClassPathXmlApplicationContext("spring-hibernate.xml");
		bookShopService = ctx.getBean(BookShopService.class);
		bookShopDao = ctx.getBean(BookShopDao.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testCashier() {
		cashier.checkout("aa", Arrays.asList("1001","1002"));
	}
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource=ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void testBooShopDaoUpdateUserAccount() {
		bookShopDao.updateUserAccount("aa", 100);
	}
	@Test
	public void testBookShopService() {
		bookShopService.purchase("aa", "1001");
	}

}
