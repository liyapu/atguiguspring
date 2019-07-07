package com.lyp.learn.demo.tx.anno.service.impl;

import com.lyp.learn.demo.tx.anno.service.BookShopService;
import com.lyp.learn.demo.tx.anno.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {

    @Autowired
    private BookShopService bookShopService;

    @Transactional
    @Override
    public void checkout(String userName, List<String> isbns) {
        for(String isbn : isbns){
            bookShopService.purchase(userName,isbn);
        }
    }
}
