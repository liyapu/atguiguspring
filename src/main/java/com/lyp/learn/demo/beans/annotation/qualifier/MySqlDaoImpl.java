package com.lyp.learn.demo.beans.annotation.qualifier;

import org.springframework.stereotype.Service;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-04 12:44
 */
@Service
public class MySqlDaoImpl implements Dao {
    @Override
    public void save() {
        System.out.println("MySqlDaoImpl...save....");
    }
}
