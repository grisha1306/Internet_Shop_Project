package com.company.daoimpl;

import com.company.dao.GenericDao;
import com.company.model.Parameters;
import com.company.model.ProductInfo;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@SuppressWarnings("unchecked")
public class ParametersDaoImpl implements GenericDao<Parameters> {

    @Override
    public void save(Parameters parameters) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(parameters);
        transaction.commit();
        session.close();
    }

    @Override
    public Parameters getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Parameters parameter = session.get(Parameters.class, id);
        session.close();
        return parameter;
    }

    @Override
    public void update(Parameters parameters) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(parameters);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Parameters parameters) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(parameters);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Parameters> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Parameters> parameters = (List<Parameters>) session.createQuery("from Parameters ").list();
        session.close();
        return parameters;
    }

    public List<ProductInfo> getAllInfoAboutProduct(Integer productId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductInfo> productInfos = (List<ProductInfo>) session.createQuery("select new com.company.model.ProductInfo(p.value, p.attributeId.attributeName) from com.company.model.Parameters p "
                                        + "where p.objectId.id = :productId").setParameter("productId", productId).list();
        session.close();
        return productInfos;
    }
}
