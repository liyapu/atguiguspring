package com.lyp.learn.demo.tx.xml.dao.impl;

import com.lyp.learn.demo.tx.xml.dao.BookShopDao;
import com.lyp.learn.demo.tx.xml.expection.BookStockException;
import com.lyp.learn.demo.tx.xml.expection.UserAccountException;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookShopDaoImpl implements BookShopDao {

	private JdbcTemplate jdbcTemplate;

	//添加setter方法，以便在xml配置中注入 jdbcTemplate
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		int price = jdbcTemplate.queryForObject(sql,Integer.class,isbn);
		return price;
	}

	@Override
	public void updateBookStock(String isbn) {
		//检查书的库存是否足够, 若不够, 则抛出异常
		String sql = "SELECT stock FROM book_stock WHERE isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql,Integer.class,isbn);
		if(stock <= 0){
			throw  new BookStockException("库存不足");
		}
		String sql2 = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
		jdbcTemplate.update(sql2,isbn);
	}

	@Override
	public void updateUserAccount(String userName, int price) {
		//验证余额是否足够, 若不足, 则抛出异常
		String sql = "SELECT balance FROM account WHERE user_name = ?";
		int balance = jdbcTemplate.queryForObject(sql,Integer.class,userName);
		if(balance < price){
			throw new UserAccountException("余额不足");
		}
		String sql2 = "UPDATE account SET balance = balance - ? WHERE user_name = ?";
		jdbcTemplate.update(sql2,price,userName);
	}
}
