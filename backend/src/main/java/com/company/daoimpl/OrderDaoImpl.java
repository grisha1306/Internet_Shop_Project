package com.company.daoimpl;

import com.company.dao.OrderDao;
import com.company.model.*;
import com.company.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void addToOrder(OrderModel orderModel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query<Integer> queryUserId =  session.createQuery("select p.objectId.objectId "
                + " from com.company.model.Parameters p "
                + " where p.value = :username").setParameter("username", orderModel.getEmail());
        int userId = queryUserId.getSingleResult();
        Objects userIdObj = session.get(Objects.class, userId);
        Objects productIdObj = session.get(Objects.class, orderModel.getProductId());
        Orders orders = new Orders();
        orders.setUser(userIdObj);
        orders.setProduct(productIdObj);
        session.save(orders);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Product> getOrder(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Integer> queryUserId =  session.createQuery("select p.objectId.objectId "
                + " from com.company.model.Parameters p "
                + " where p.value = :username").setParameter("username", username);
        Integer userId = queryUserId.getSingleResult();
        List<Product> products = (List<Product>) session.createQuery("select new com.company.model.Product(o.product.objectId, o.product.objectName, o.product.objectType.typeName) from Orders o " +
                "where o.user.objectId = :userId").setParameter("userId", userId ).list();

        session.close();
        return products;
    }

    @Override
    public boolean delete(Integer productId, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            Query<Integer> queryUserId =  session.createQuery("select p.objectId.objectId "
                    + " from com.company.model.Parameters p "
                    + " where p.value = :username").setParameter("username", email);
            int userId = queryUserId.getSingleResult();
            Query queryDelete = session.createQuery("delete from Orders o " +
                "where o.product.objectId = :productId and o.user.objectId = :userId ")
                .setParameter("productId", productId )
                .setParameter("userId", userId );

            int rowCount = queryDelete.executeUpdate();
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
