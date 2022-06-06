package com.company.daoimpl;

import com.company.dao.GenericDao;
import com.company.model.Attributes;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

@SuppressWarnings("unchecked")
public class AttributesDaoImpl implements GenericDao<Attributes> {

    @Override
    public void save(Attributes attributes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(attributes);
        transaction.commit();
        session.close();
    }

    @Override
    public Attributes getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Attributes attribute = session.get(Attributes.class, id);
        session.close();
        return attribute;
    }

    @Override
    public void update(Attributes attributes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(attributes);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Attributes attributes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(attributes);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Attributes> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Attributes> attributes = (List<Attributes>) session.createQuery("From Attributes ").list();
        session.close();
        return attributes;
    }
}
