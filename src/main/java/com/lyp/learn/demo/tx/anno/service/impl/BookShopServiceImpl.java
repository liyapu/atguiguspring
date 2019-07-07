package com.lyp.learn.demo.tx.anno.service.impl;

import com.lyp.learn.demo.tx.anno.dao.BookShopDao;
import com.lyp.learn.demo.tx.anno.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 添加事务注解
     * 1. 使用 propagation 指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时，
     * 如何使用事务，默认取值为 REQUIRED ,即使用调用方法的事务。
     *
     *  REQUIRES_NEW ：使用自己的事务，调用的事务方法的事务被挂起
     *
     *  2. 使用 isolation 指定事务的隔离级别，一般不配置，使用数据库自身指定的
     *
     *  3. 默认情况下，spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的
     *  属性进行设置(rollbackFor,rollbackForClassName),通常情况下使用默认值即可
     *
     *  4. 使用 readOnly 指定事务是否为只读，表示这个事务只读取数据单不更新数据
     *  这样可以帮助数据库引擎优化事务
     *
     *  5. 使用 timeout 指定强制回滚之前事务可以占用的时间
     * @param userName
     * @param isbn
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
                    isolation = Isolation.REPEATABLE_READ,
                    rollbackFor = {IOException.class,SQLException.class},
                    timeout = 5)
    @Override()
    public void purchase(String userName, String isbn) {
        //1.获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        //2.更新库存
        bookShopDao.updateBookStock(isbn);

        //3.更新账户余额
        bookShopDao.updateUserAccount(userName,price);

    }
}
