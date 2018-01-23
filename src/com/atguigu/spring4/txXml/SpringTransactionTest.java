package com.atguigu.spring4.txXml;

import com.atguigu.spring4.txXml.service.BookShopService;
import com.atguigu.spring4.txXml.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by miaomiao on 18-1-21.
 */
public class SpringTransactionTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService;
    private Cashier cashier;

    {
        ctx = new ClassPathXmlApplicationContext("resources4/applicationContext-xml.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }


    @Test   //测试事物的传播行为
    public void testTransactionlPropagation(){
        cashier.checkout("AA", Arrays.asList(1001,1002));
    }

    @Test
    public void testBookShopService(){
        bookShopService.purchase("AA",1001);
    }


}
