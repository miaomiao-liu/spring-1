package com.atguigu.spring4.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by miaomiao on 18-1-23.
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    BookShopDao bookShopDao;


    /**
     * 添加事务注解
     * 1.使用propagation指定事务的传播行为，即当前事务被另外一个事务调用时，如何使用事务
     *   默认属性值为 REQUIRED ：只用调用方法的事务
     *   REQUIRED_NEW : 开启新的事务 ，调用方法的事务被挂起
     * 2.使用isolation指定事务的隔离级别，常用READ_COMMITTED
     * 3.默认情况下Spring的声明式事务对所有运行时异常进行回滚(通常取默认)，也可以通过对应的属性进行设置
     * 4.readOnly:指定事务是否只读，表示事务只读数据但不更新数据
     * 5.timeout：指定强制回滚之前事务可以占用的时间,超过强制回滚
     * @param username
     * @param isbn
     */
//
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 3)
    @Override
    public void purchase(String username, int isbn) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //获取书的单价
        int price =  bookShopDao.findBookPriceByid(isbn);
        //更新书的库存
        bookShopDao.updateBookStock(isbn);
        //更新用户余额
        bookShopDao.updateUserAccount(username,price);
    }
}
