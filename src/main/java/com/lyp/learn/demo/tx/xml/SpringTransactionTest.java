package com.lyp.learn.demo.tx.xml;


import com.lyp.learn.demo.tx.xml.dao.BookShopDao;
import com.lyp.learn.demo.tx.xml.service.BookShopService;
import com.lyp.learn.demo.tx.xml.service.CashierService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTransactionTest {

    ApplicationContext acx = null;
    BookShopDao bookShopDao = null;
    BookShopService bookShopService = null;
    CashierService cashierService = null;

    {
        acx = new ClassPathXmlApplicationContext("tx-xml.xml");
        bookShopDao = acx.getBean(BookShopDao.class);
        bookShopService = acx.getBean(BookShopService.class);
        cashierService = acx.getBean(CashierService.class);
    }


    @Test
    public void testBookShopDaoFindBookPriceByIsbn(){
       int price =  bookShopDao.findBookPriceByIsbn("9002233");
        System.out.println(price);
    }

    @Test
    public void testBookShopDaoUpdateBookStock(){
        bookShopDao.updateBookStock("9002233");
    }


    @Test
    public void testBookShopDaoUpdateUserAccount(){
        bookShopDao.updateUserAccount("李四",20);
    }

    /**
     * 测试 事务
     * 购买一本书
     */
    @Test
    public void testBookShopServicePurchase(){
        bookShopService.purchase("李四","9002233");
    }

    /**
     * 测试事务的传播行为
     */
    @Test
    public void testCashierServiceCheckout(){
        cashierService.checkout("李四",Arrays.asList("9002233","8005678"));
    }
}
