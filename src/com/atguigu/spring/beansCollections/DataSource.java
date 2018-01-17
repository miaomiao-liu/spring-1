package com.atguigu.spring.beansCollections;

import java.util.Properties;

/**
 * Created by miaomiao on 18-1-17.
 */
public class DataSource {
    Properties properties;

    public Properties getProperties() {
        return properties;
    }

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
