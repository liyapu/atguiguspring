package com.lyp.learn.spring6.demo01;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyapu
 * @date 2023-04-08 19:39
 * @description
 */
public class UserTest {

    /**
     * 自己生成 user对象，自己管理
     */
    @Test
    public void testUser01() {
        User user = new User();
        user.add();
    }

    /**
     * 通过spring生成uer对象，让spring帮我们管理，需要时去拿即可
     */
    @Test
    public void testUser02() {
        //1.加载spring配置文件，对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring6/beans.xml");

        //2.获取创建的对象
        User user = (User) context.getBean("user");

        //3.使用对象调用方法进行测试
        user.add();
    }

}













