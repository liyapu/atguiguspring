package com.lyp.learn.demo.beans.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-03 11:26
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans-properties.xml");

        DataSource dataSource = (DataSource) acx.getBean("dataSource");
        System.out.println(dataSource);
        System.out.println();

        DbConfig dbConfig = new DbConfig();
        System.out.println(dbConfig);
        dbConfig = (DbConfig) acx.getBean("dbConfig");
        System.out.println(dbConfig);
    }
}
