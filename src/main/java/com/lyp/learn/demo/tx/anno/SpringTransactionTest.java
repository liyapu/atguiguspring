package com.lyp.learn.demo.tx.anno;

import com.lyp.learn.demo.tx.anno.dao.BookShopDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

    ApplicationContext acx = null;
    BookShopDao bookShopDao = null;

    {
        acx = new ClassPathXmlApplicationContext("tx-anno.xml");
        bookShopDao = acx.getBean(BookShopDao.class);
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
}
