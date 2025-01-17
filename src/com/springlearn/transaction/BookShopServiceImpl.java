package com.springlearn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookShopServiceImpl implements BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao=null;
	
	/**
	 * 添加事务注解
	 * 1. 使用propagation 指定事务转播行为，即当前事务被另一个事务方法调用时如何使用事务，默认取值为 REQUIRED ,即使用调用方法的事务
	 * REQUIRES_NEW: 使用自己的事务，调用者挂起
	 * 2. 使用isolation 指定事务的隔离级别，最常用的为Isolation.READ_COMMITTED
	 * 3. 默认情况下Spring的声明式事务对所有的运行时异常回滚，也可以通过对应的属性设置，通常情况下取默认值即可
	 * 4. 使用readOnly 指定事务是否为只读。表示这个事务只读取数据不更新数据，这样可以帮助数据库引擎优化事务
	 * 	      若真的是一个只读数据库的方法，应设置readOnly=true
	 * 5. 使用timeout 指定强制回滚之前事务可以占用的时间
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW,
			isolation = Isolation.READ_COMMITTED,
			readOnly = false,
			noRollbackFor = {UserAccountException.class},
			
			timeout = 3 )
	@Override
	public void purchase(String username, String isbn) {
		/**
		 * 1.获取书的单价
		 * 2.更新书的库存
		 * 3。更新用户余额
		 */
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int price  = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}
}
