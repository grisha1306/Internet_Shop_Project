package com.company.daoimpl;

import com.company.dao.GenericDao;
import com.company.model.References;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReferencesDaoImpl implements GenericDao<References> {
    @Override
    public void create(References references) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(references);
        transaction.commit();
        session.close();
    }

    @Override
    public References getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        References reference = session.get(References.class, id);
        session.close();
        return reference;
    }

    @Override
    public void update(References references) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(references);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(References references) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(references);
        transaction.commit();
        session.close();
    }

    @Override
    public List<References> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<References> references = (List<References>) session.createQuery("From References ").list();
        session.close();
        return references;
    }
}
