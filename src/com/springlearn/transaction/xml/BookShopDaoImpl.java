package com.springlearn.transaction.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class BookShopDaoImpl implements BookShopDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql ="SELECT price FROM book WHERE isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	@Override
	public void updateBookStock(String isbn) {
		String sql2="SELECT stock  FROM book_stock WHERE isbn = ? ";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
		if(stock==0) {
			throw new BookStockException("¿â´æ²»×ã");
		}
		String sql="UPDATE book_stock SET stock=stock-1 WHERE isbn = ? ";
		jdbcTemplate.update(sql,isbn);
		
	}

	@Override
	public void updateUserAccount(String username, int price) {
		String sql2="SELECT balance FROM accounts WHERE username = ? ";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
		if(balance<price) {
			throw new BookStockException("Óà¶î²»×ã");
		}
		String sql="UPDATE accounts SET balance = balance - ? WHERE username = ? ";
		jdbcTemplate.update(sql,price,username);
	}

}
