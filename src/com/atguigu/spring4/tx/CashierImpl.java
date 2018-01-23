package com.atguigu.spring4.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by miaomiao on 18-1-23.
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Transactional
    @Override
    public void checkout(String username, List<Integer> isbns) {
        for (int isbn : isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
