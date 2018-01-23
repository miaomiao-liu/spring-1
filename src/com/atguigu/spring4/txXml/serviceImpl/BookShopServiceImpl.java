package com.atguigu.spring4.txXml.serviceImpl;

import com.atguigu.spring4.txXml.BookShopDao;
import com.atguigu.spring4.txXml.service.BookShopService;

/**
 * Created by miaomiao on 18-1-23.
 */
public class BookShopServiceImpl implements BookShopService {

    BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    @Override
    public void purchase(String username, int isbn) {

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //获取书的单价
        int price =  bookShopDao.findBookPriceByid(isbn);
        //更新书的库存
        bookShopDao.updateBookStock(isbn);
        //更新用户余额
        bookShopDao.updateUserAccount(username,price);
    }
}
