package com.company.daoimpl;

import com.company.dao.UserDao;
import com.company.model.*;
import com.company.service.MailService;
import com.company.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configurable
public class UserDaoImpl implements UserDao {

    public User findByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Integer> queryUserId =  session.createQuery("select p.objectId.objectId "
                + " from com.company.model.Parameters p "
                + " where p.value = :username").setParameter("username", username);
        int userId = queryUserId.getSingleResult();

        Query<String> queryUserPassword =  session.createQuery("select p.value "
                + " from com.company.model.Parameters p "
                + " where p.objectId.objectId = :objectId and p.attributeId.attributeName = :Password ").setParameter("objectId", userId).setParameter("Password", "Password");
        String userPassword = queryUserPassword.getSingleResult();

        Query<String> queryUserRole =  session.createQuery("select p.value "
                + " from com.company.model.Parameters p "
                + " where p.objectId.objectId = :objectId and p.attributeId.attributeName = :Role ").setParameter("objectId", userId).setParameter("Role", "Role");
        String userRole = queryUserRole.getSingleResult();

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role(userRole));

        User user = new User(username, userPassword, roleSet);

        session.close();

        return user;
    }

    @Override
    public boolean save(User user) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query<Integer> findUsername =  session.createQuery("select o.objectName "
                + " from com.company.model.Objects o "
                + " where o.objectName = :username").setParameter("username", user.getUsername());
        List<Integer> listUsername = findUsername.list();

        if ( listUsername.size() == 1 )
            return false;

        ObjectType objectType = session.get(ObjectType.class, 3);
        Objects obj = new Objects();
        obj.setObjectName(user.getUsername());
        obj.setObjectType(objectType);
        session.save(obj);

        Parameters parameterUsername = new Parameters();
        parameterUsername.setObjectId(obj);
        Attributes attributeUsername  = session.get(Attributes.class, 3);
        parameterUsername.setAttributeId(attributeUsername);
        parameterUsername.setValue(user.getUsername());
        session.save(parameterUsername);

        Parameters parameterPassword = new Parameters();
        parameterPassword.setObjectId(obj);
        Attributes attributePassword  = session.get(Attributes.class, 4);
        parameterPassword.setAttributeId(attributePassword);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        parameterPassword.setValue(bCryptPasswordEncoder.encode(user.getPassword()));
        session.save(parameterPassword);

        Parameters parameterRole = new Parameters();
        parameterRole.setObjectId(obj);
        Attributes attributeRole  = session.get(Attributes.class, 5);
        parameterRole.setAttributeId(attributeRole);
        parameterRole.setValue("ROLE_USER");
        session.save(parameterRole);

        transaction.commit();
        session.close();

        MailService mailService = new MailService();
        mailService.send(user.getUsername(), "Success Register" , "Thank you for register in our Internet shop" );

        return true;
    }

    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> queryUsername = session.createQuery("select new com.company.model.User(p.objectId.objectId, p.value) from Parameters p where p.objectId.objectType.typeName = 'user' and p.attributeId.attributeName = 'Username'").list();
        List<Role> queryRole = session.createQuery("select new com.company.model.Role( p.objectId.objectId, p.value) from Parameters p where p.objectId.objectType.typeName = 'user' and p.attributeId.attributeName = 'Role'").list();

        List<User> users = new ArrayList<>();
        List<Role> roles = new ArrayList<>();

        for( int i = 0; i < queryUsername.size(); i ++ ) {
            for ( int j = 0; j < queryRole.size(); j++ ) {
                if ( queryUsername.get(i).getId() == queryRole.get(j).getId()) {
                    roles.add(queryRole.get(j));
                }
            }
            users.add(new User(queryUsername.get(i).getId() , queryUsername.get(i).getUsername(), roles.get(i).getName()));
        }

        session.close();
        return users;
    }

    @Override
    public boolean deleteUser(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            Query queryDeleteFromParameters = session.createQuery("delete from Parameters p " +
                            "where p.objectId.objectId = :userId")
                    .setParameter("userId", id );
            int rowCountParametersDelete = queryDeleteFromParameters.executeUpdate();
            Query queryDeleteFromObjects = session.createQuery("delete from Objects o " +
                            "where o.objectId = :userId")
                    .setParameter("userId", id );
            int rowCountObjectsDelete = queryDeleteFromObjects.executeUpdate();

            transaction.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}
