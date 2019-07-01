package com.lyp.learn.demo.beans.collections;

import java.util.Properties;

/**
 * @Author: liyapu
 * @Description:
 * @create: 2019-07-02 00:40
 */
public class DataSource {
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
