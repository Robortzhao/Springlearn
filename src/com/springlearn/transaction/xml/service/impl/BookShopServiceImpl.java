package com.springlearn.transaction.xml.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springlearn.transaction.xml.BookShopDao;
import com.springlearn.transaction.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {
	
	private BookShopDao bookShopDao=null;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	@Override
	public void purchase(String username, String isbn) {
		/**
		 * 1.��ȡ��ĵ���
		 * 2.������Ŀ��
		 * 3�������û����
		 */
		int price  = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}
}
