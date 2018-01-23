package com.atguigu.spring4.txXml;


/**
 * Created by miaomiao on 18-1-21.
 */
public interface BookShopDao {

    //根据书号查询单价
    int findBookPriceByid(int isbn);

    //更新库存，库存减一
    void updateBookStock(int isbn);

    //根新账户余额
    void updateUserAccount(String username, int price);

}
