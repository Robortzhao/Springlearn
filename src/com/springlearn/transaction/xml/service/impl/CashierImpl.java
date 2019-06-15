package com.springlearn.transaction.xml.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlearn.transaction.BookShopService;
import com.springlearn.transaction.Cashier;


public class CashierImpl implements Cashier {
	
	
	private BookShopService bookShopService=null;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	@Override
	public void checkout(String username, List<String> isbns) {
		// TODO Auto-generated method stub
		for(String isbn:isbns) {
			bookShopService.purchase(username, isbn);
		}
	}
}
