package com.lyp.learn.demo.tx.xml.service.impl;

import com.lyp.learn.demo.tx.xml.service.BookShopService;
import com.lyp.learn.demo.tx.xml.service.CashierService;

import java.util.List;

public class CashierServiceImpl implements CashierService {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String userName, List<String> isbns) {
        for(String isbn : isbns){
            bookShopService.purchase(userName,isbn);
        }
    }
}
