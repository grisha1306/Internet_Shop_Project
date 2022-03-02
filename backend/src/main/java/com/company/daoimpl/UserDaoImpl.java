package com.company.daoimpl;

import com.company.dao.GenericDao;
import com.company.model.User;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements GenericDao<User> {

    public User findByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Integer> queryUserId =  session.createQuery("select p.objectId.objectId "
                + " from com.company.model.Parameters p "
                + " where p.value = :username").setParameter("username", username);
        int objectId = queryUserId.getSingleResult();

        Query<String> queryUserPassword =  session.createQuery("select p.value "
                + " from com.company.model.Parameters p "
                + " where p.objectId.objectId = :objectId and p.attributeId.attributeName = :Password ").setParameter("objectId", objectId).setParameter("Password", "Password");
        String userPassword = queryUserPassword.getSingleResult();

        Query<String> queryUserRole =  session.createQuery("select p.value "
                + " from com.company.model.Parameters p "
                + " where p.objectId.objectId = :objectId and p.attributeId.attributeName = :Role ").setParameter("objectId", objectId).setParameter("Role", "Role");
        String userRole = queryUserRole.getSingleResult();

        User user = new User(username, userPassword, userRole);

        session.close();
        return user;
    }

    @Override
    public void create(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query<Integer> queryObjectId =  session.createQuery("select o.objectId "
                + " from com.company.model.Objects o ");

        List<Integer> listObjId = queryObjectId.list();
        int check = listObjId.size();

        Query query = session.createQuery(" insert into Objects (object_id, object_name, object_type, parent_id) " +
                " values (:objectId, :objectName, :objectType, :parentId) ").setParameter("objectId", 5).setParameter("objectName", user.getUsername()).setParameter("objectType", 3).setParameter("parentId", null);

        transaction.commit();
        session.close();
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {
    }


    public void deleteById(Integer userId) {
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
