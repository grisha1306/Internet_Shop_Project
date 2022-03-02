package com.company.daoimpl;

import com.company.dao.GenericDao;
import com.company.model.ObjectsType;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ObjectsTypeDaoImpl implements GenericDao<ObjectsType> {

    @Override
    public void create(ObjectsType objectsType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(objectsType);
        transaction.commit();
        session.close();
    }

    @Override
    public ObjectsType getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ObjectsType objectsType = session.get(ObjectsType.class, id);
        session.close();
        return objectsType;
    }

    @Override
    public void update(ObjectsType objectsType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(objectsType);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(ObjectsType objectsType) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(objectsType);
        transaction.commit();
        session.close();
    }

    @Override
    public List<ObjectsType> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ObjectsType> objectsType = (List<ObjectsType>) session.createQuery("From ObjectsType ").list();
        session.close();
        return objectsType;
    }
}
