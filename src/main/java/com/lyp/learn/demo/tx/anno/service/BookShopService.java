package com.lyp.learn.demo.tx.anno.service;

public interface BookShopService {

	/**
	 * 购买书
	 * @param userName
	 * @param isbn
	 */
	void purchase(String userName, String isbn);
	
}
