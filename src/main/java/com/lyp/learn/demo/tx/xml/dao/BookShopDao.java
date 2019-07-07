package com.lyp.learn.demo.tx.xml.dao;

public interface BookShopDao {

	/**
	 * 根据书号获取书的单价
	 * @param isbn
	 * @return
	 */
	 int findBookPriceByIsbn(String isbn);

	/**
	 * 更新数的库存. 使书号对应的库存 - 1
	 * @param isbn
	 */
	 void updateBookStock(String isbn);

	/**
	 * 更新用户的账户余额: 使 userName 的 balance - price
	 * @param userName
	 * @param price
	 */
	 void updateUserAccount(String userName, int price);
}
