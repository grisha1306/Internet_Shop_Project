package com.company.daoimpl;

import com.company.dao.GenericDao;
import com.company.model.ObjectType;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@SuppressWarnings("unchecked")
public class ObjectsTypeDaoImpl implements GenericDao<ObjectType> {

    @Override
    public void save(ObjectType objectType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(objectType);
        transaction.commit();
        session.close();
    }

    @Override
    public ObjectType getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ObjectType objectType = session.get(ObjectType.class, id);
        session.close();
        return objectType;
    }

    @Override
    public void update(ObjectType objectType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(objectType);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(ObjectType objectType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(objectType);
        transaction.commit();
        session.close();
    }

    @Override
    public List<ObjectType> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ObjectType> objectType = (List<ObjectType>) session.createQuery("From ObjectType ").list();
        session.close();
        return objectType;
    }
}
