package com.atguigu.spring4.txXml.service;

import java.util.List;

/**
 * Created by miaomiao on 18-1-23.
 */
public interface Cashier {

    void checkout(String username, List<Integer> isbns);
}
