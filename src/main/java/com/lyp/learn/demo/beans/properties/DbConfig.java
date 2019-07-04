package com.lyp.learn.demo.beans.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-03 11:56
 */
@PropertySource(value={"classpath:db.properties"})
@Service("dbConfig")
public class DbConfig {
    @Value(value = "${user}")
    private String user;
    @Value(value = "${password}")
    private String password;
    @Value("${driverClass}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Override
    public String toString() {
        return "DbConfig{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", driverClass='" + driverClass + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                '}';
    }
}
