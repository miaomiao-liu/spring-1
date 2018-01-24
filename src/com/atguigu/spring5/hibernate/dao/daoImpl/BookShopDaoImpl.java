package com.atguigu.spring5.hibernate.dao.daoImpl;

import com.atguigu.spring5.hibernate.dao.BookShopDao;
import com.atguigu.spring5.hibernate.exception.BookStockException;
import com.atguigu.spring5.hibernate.exception.UserAccountException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by miaomiao on 18-1-24.
 */
@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private SessionFactory sessionFactory;

    //获取跟当前线程绑定的session
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int findBookPriceByid(String isbn) {
        String hql = "SELECT b.price FROM Book b WHERE isbn = ?";
        Query query = getSession().createQuery(hql).setParameter(0,isbn);
        return (int) query.uniqueResult();
    }

    @Override
    public void updateBookStock(String isbn) {

        String hql2 = "SELECT b.stock FROM Book b WHERE isbn = ?";
        int stock = (int) getSession().createQuery(hql2).setParameter(0,isbn).uniqueResult();
        if (stock == 0){
            throw new BookStockException("库存不足");
        }

        String hql = "UPDATE Book b SET b.stock = b.stock - 1 WHERE isbn = ?";
        getSession().createQuery(hql).setParameter(0,isbn).executeUpdate();
    }

    @Override
    public void updateUserAccount(String username, int price) {
        String hql2 = "SELECT a.balance FROM Account a WHERE username = ?";
        int balance = (int) getSession().createQuery(hql2).setParameter(0,username).uniqueResult();
        if (balance < price){
            throw new UserAccountException("余额不足");
        }
        String hql = "UPDATE Account a SET a.balance = a.balance - ? WHERE a.username = ?";
        getSession().createQuery(hql).setParameter(0,price).setParameter(1,username).executeUpdate();

    }
}
