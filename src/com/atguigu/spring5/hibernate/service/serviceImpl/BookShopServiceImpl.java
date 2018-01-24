package com.atguigu.spring5.hibernate.service.serviceImpl;

import com.atguigu.spring5.hibernate.dao.BookShopDao;
import com.atguigu.spring5.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by miaomiao on 18-1-24.
 */
@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 事务回滚没有配置成功： mysql InnoDB支持事务，配置切面路径正确，没有找到回滚失败的原因
     */
    @Override
    public void purchase(String username, String isbn) {
        int price = bookShopDao.findBookPriceByid(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username,price);
    }
}
