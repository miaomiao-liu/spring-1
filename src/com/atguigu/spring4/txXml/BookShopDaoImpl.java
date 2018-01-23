package com.atguigu.spring4.txXml;

import com.atguigu.spring4.txXml.BookShopDao;
import com.atguigu.spring4.txXml.BookStockException;
import com.atguigu.spring4.txXml.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by miaomiao on 18-1-21.
 */
public class BookShopDaoImpl implements BookShopDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findBookPriceByid(int isbn) {
        String sql = "SELECT price FROM book WHERE isbn = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    @Override
    public void updateBookStock(int isbn) {
        //检查书的库存是否足够，若不够，则抛出异常
        String sql2 = "SELECT stock FROM book_stock WHERE isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql2,Integer.class, isbn);
        if (stock == 0){
            throw new BookStockException("库存不足");
        }
        String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
        jdbcTemplate.update(sql,isbn);
    }

    @Override
    public void updateUserAccount(String username, int price) {
        //检查用户余额是否足够，若不够，则抛出异常
        String sql2 = "SELECT balance FROM account WHERE username = ?";
        int balance = jdbcTemplate.queryForObject(sql2,Integer.class, username);
        if (balance < price){
            throw new UserAccountException("余额不足");
        }
        String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
        jdbcTemplate.update(sql,price,username);
    }
}
