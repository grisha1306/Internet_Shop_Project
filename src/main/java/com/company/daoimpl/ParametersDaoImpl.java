package com.company.daoimpl;

import com.company.dao.ParametersDao;
import com.company.model.Attributes;
import com.company.model.Parameters;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ParametersDaoImpl implements ParametersDao {

    @Override
    public void create(Parameters parameters) {
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
        List<Parameters> parameters = (List<Parameters>) session.createQuery("From Parameters ").list();
        session.close();
        return parameters;
    }
}
