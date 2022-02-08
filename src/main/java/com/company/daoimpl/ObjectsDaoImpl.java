package com.company.daoimpl;

import com.company.dao.ObjectsDao;
import com.company.model.Attributes;
import com.company.model.Objects;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ObjectsDaoImpl implements ObjectsDao {

    @Override
    public void create(Objects objects) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(objects);
        transaction.commit();
        session.close();
    }

    @Override
    public Objects getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Objects object = session.get(Objects.class, id);
        session.close();
        return object;
    }

    @Override
    public void update(Objects objects) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(objects);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Objects objects) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(objects);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Objects> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Objects> objects = (List<Objects>) session.createQuery("From Objects ").list();
        session.close();
        return objects;
    }
}
