package com.lyp.learn.demo.tx.anno.dao.impl;

import com.lyp.learn.demo.tx.anno.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		int price = jdbcTemplate.queryForObject(sql,Integer.class,isbn);
		return price;
	}

	@Override
	public void updateBookStock(String isbn) {
		String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
		jdbcTemplate.update(sql,isbn);
	}

	@Override
	public void updateUserAccount(String user, int price) {
		String sql = "UPDATE account SET balance = balance - ? WHERE user = ?";
		jdbcTemplate.update(sql,price,user);
	}
}
