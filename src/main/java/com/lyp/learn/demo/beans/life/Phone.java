package com.lyp.learn.demo.beans.life;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author liyapu
 * @date 2024-04-13 17:59
 * @description Spring中 afterPropertiesSet 的用法介绍  https://blog.csdn.net/Swofford/article/details/133994759
 * 一、afterPropertiesSet概述
 * 1、afterPropertiesSet 是Spring Framework中的一种初始化方法，它是InitializingBean的一个回调方法，可以在bean属性设置完成之后执行一些特定的操作。
 * 如果你的bean实现了 InitializingBean 接口，那么Spring容器将在bean属性设置完成后自动调用这个方法。
 *
 * 2、afterPropertiesSet 方法通常用于执行那些不能在配置文件中完成的初始化操作，如数据库连接池的相关初始化等。因为在Spring容器初始化bean时，在bean属性设置完成后，【会在执行其他初始化方法之前】先执行afterPropertiesSet方法。
 *
 * 二、实现InitializingBean接口的方式
 * 方法1：实现 InitializingBean 接口，并重写 afterPropertiesSet 方法。
 *
 * public class MyBean implements InitializingBean {
 *
 * private String message;
 *
 * public void setMessage(String message) {
 * this.message = message;
 * }
 *
 * public void afterPropertiesSet() throws Exception {
 * System.out.println("执行MyBean的初始化方法，message=" + message);
 * }
 * }
 *
 *
 * 方法2：使用注解 @PostConstruct 来代替 afterPropertiesSet 方法.
 *
 * public class MyBean {
 *
 * private String message;
 * @PostConstruct public void init() {
 * System.out.println("执行MyBean的初始化方法，message=" + message);
 * }
 *
 * public void setMessage(String message) {
 * this.message = message;
 * }
 * }
 *
 * 三、afterPropertiesSet方法的调用时机
 * 1、如果bean实现了 InitializingBean 接口，那么在所有的bean属性被设置完毕后，容器会 自动调用 该bean的 afterPropertiesSet 方法来进行一些自定义的初始化操作。
 * 2、如果一个bean同时指定了init-method方法和实现了 InitializingBean 接口，则会先调用 afterPropertiesSet 方法，然后调用 init-method 方法。
 * 3、如果bean没有实现 InitializingBean 接口，并且没有指定init-method方法，则不会调用任何方法。
 *
 * 四、使用afterPropertiesSet方法的注意事项
 * 1、在实现 afterPropertiesSet 方法时，一定不要抛出异常 ！ 因为一旦抛出异常，Spring容器就无法完成bean的初始化工作，也就无法启动应用程序。
 * 2、尽管实现了 afterPropertiesSet 方法，但最好还是使用 init-method 属性来定义初始化的方法。这样可以使代码更加具有可读性，并且可以使代码更复杂的初始化操作分解到不同的方法中，提高代码的可维护性。
 * 3、afterPropertiesSet方法可以访问bean的任何属性，并可以在初始化后执行访问方法。
 *
 * 五、小结
 * 1、afterPropertiesSet 是Spring Framework中的一种初始化方法，用于在bean属性设置完成之后执行一些特定的操作。
 * 2、默认情况下，Spring容器会在所有bean属性被设置完毕后自动调用 afterPropertiesSet 方法。
 * 3、在实现 afterPropertiesSet 方法时，一定不要抛出异常；
 * 同时推荐使用 init-method 属性来定义初始化方法，提高代码的可读性和可维护性。
 */
public class Phone implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Phone初始化 afterPropertiesSet");
    }
}
