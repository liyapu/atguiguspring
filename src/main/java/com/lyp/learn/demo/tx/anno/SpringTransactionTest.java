package com.lyp.learn.demo.tx.anno;

import com.lyp.learn.demo.tx.anno.dao.BookShopDao;
import com.lyp.learn.demo.tx.anno.service.BookShopService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

    ApplicationContext acx = null;
    BookShopDao bookShopDao = null;
    BookShopService bookShopService = null;

    {
        acx = new ClassPathXmlApplicationContext("tx-anno.xml");
        bookShopDao = acx.getBean(BookShopDao.class);
        bookShopService = acx.getBean(BookShopService.class);
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
}
