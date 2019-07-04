package com.lyp.learn.demo.beans.annotation.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    @Qualifier("mySqlDaoImpl")
    private Dao dao;

    void add(){
        dao.save();
    }
}
