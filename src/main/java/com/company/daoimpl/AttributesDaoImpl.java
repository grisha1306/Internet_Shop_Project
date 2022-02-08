package com.company.daoimpl;

import com.company.dao.AttributesDao;
import com.company.model.Attributes;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AttributesDaoImpl implements AttributesDao {

    @Override
    public void create(Attributes attributes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(attributes);
        transaction.commit();
        session.close();
    }

    @Override
    public Attributes getById(Integer id) {
        return HibernateUtil.getSessionFactory().openSession().get(Attributes.class, id);
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
        HibernateUtil.getSessionFactory().openSession().delete(attributes);
    }

    @Override
    public List<Attributes> findAll() {
        List<Attributes> attributes = (List<Attributes>) HibernateUtil.getSessionFactory().openSession().createQuery("From Attributes ").list();
        return  attributes;
    }
}
