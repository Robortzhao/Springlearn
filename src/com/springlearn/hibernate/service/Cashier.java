package com.springlearn.hibernate.service;

import java.util.List;

public interface Cashier {
	public void checkout(String username,List<String>isbns);
}
