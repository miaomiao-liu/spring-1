package com.atguigu.spring5.hibernate.service.serviceImpl;

import com.atguigu.spring5.hibernate.service.BookShopService;
import com.atguigu.spring5.hibernate.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by miaomiao on 18-1-24.
 */
@Service
public class CashierImpl implements Cashier{

    @Autowired
    private BookShopService bookShopService;

    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
