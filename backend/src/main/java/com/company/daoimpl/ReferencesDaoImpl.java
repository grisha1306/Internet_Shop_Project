package com.company.daoimpl;

import com.company.dao.GenericDao;
import com.company.model.Orders;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReferencesDaoImpl implements GenericDao<Orders> {
    @Override
    public void save(Orders orders) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(orders);
        transaction.commit();
        session.close();
    }

    @Override
    public Orders getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Orders reference = session.get(Orders.class, id);
        session.close();
        return reference;
    }

    @Override
    public void update(Orders orders) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(orders);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Orders orders) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(orders);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Orders> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Orders> references = (List<Orders>) session.createQuery("From Orders ").list();
        session.close();
        return references;
    }
}
