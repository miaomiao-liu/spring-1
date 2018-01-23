package com.atguigu.spring4.txXml.serviceImpl;

import com.atguigu.spring4.txXml.service.BookShopService;
import com.atguigu.spring4.txXml.service.Cashier;

import java.util.List;

/**
 * Created by miaomiao on 18-1-23.
 */
public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<Integer> isbns) {
        for (int isbn : isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
