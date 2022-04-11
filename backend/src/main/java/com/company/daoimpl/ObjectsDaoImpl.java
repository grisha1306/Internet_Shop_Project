package com.company.daoimpl;

import com.company.dao.GenericDao;
import com.company.model.Objects;
import com.company.model.Product;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ObjectsDaoImpl implements GenericDao<Objects> {

    @Override
    public void save(Objects objects) {
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

    public List<Product> getAllProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        Query<Product> query = session.createQuery("select new com.company.model.Product(p.value, p.objectId.objectId, p.objectId.objectName,"
//                + "p.objectId.objectType.typeName, p.attributeId.attributeName) "
//                + " from com.company.model.Parameters p ");
        List<Product> products = (List<Product>) session.createQuery("select new com.company.model.Product(o.objectId, o.objectName, o.objectType.typeName) from Objects o where objectType.typeName != 'user'").list();
//        List<Product> products = query.list();
        session.close();
        return products;
    }

}
