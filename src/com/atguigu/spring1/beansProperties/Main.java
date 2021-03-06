package com.atguigu.spring1.beansProperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by miaomiao on 18-1-18.
 */
public class Main {
    public static void main(String[] args) throws SQLException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("resources1/beans-properties.xml");

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getConnection());

        com.atguigu.spring1.beansCollections.DataSource dataSource1 = (com.atguigu.spring1.beansCollections.DataSource) ctx.getBean("dataSource1");
        System.out.println(dataSource1);

    }
}
