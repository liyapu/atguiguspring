package com.lyp.learn.demo.tx.anno.service.impl;

import com.lyp.learn.demo.tx.anno.dao.BookShopDao;
import com.lyp.learn.demo.tx.anno.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    @Transactional
    @Override
    public void purchase(String userName, String isbn) {
        //1.获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //2.更新库存
        bookShopDao.updateBookStock(isbn);

        //3.更新账户余额
        bookShopDao.updateUserAccount(userName,price);
    }
}
