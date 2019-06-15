package com.springlearn.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CashierImpl implements Cashier {
	
	@Autowired
	private BookShopService bookShopService=null;
	
	@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {
		// TODO Auto-generated method stub
		for(String isbn:isbns) {
			bookShopService.purchase(username, isbn);
		}
	}
}
