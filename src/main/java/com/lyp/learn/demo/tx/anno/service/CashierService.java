package com.lyp.learn.demo.tx.anno.service;

import java.util.List;

/**
 *  出纳员
 */
public interface CashierService {

    /**
     * 结账
     * @param userName
     * @param isbns
     */
    void checkout(String userName, List<String> isbns);
}
