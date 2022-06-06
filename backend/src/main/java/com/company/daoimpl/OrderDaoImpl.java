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
    public boolean addToOrder(OrderModel orderModel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query<Integer> queryUserId =  session.createQuery("select p.objectId.objectId "
                + " from com.company.model.Parameters p "
                + " where p.value = :username").setParameter("username", orderModel.getEmail());

        Query<Integer> queryProductAttributeId=  session.createQuery("select a.id "
                + " from com.company.model.Attributes a "
                + " where a.attributeName = :attributeName ").setParameter("attributeName", "Quantity");
        int curAttrId = queryProductAttributeId.getSingleResult();

        Query<String> queryProductQuantity =  session.createQuery("select p.value "
                + " from com.company.model.Parameters p "
                + " where p.objectId.objectId = :productId and p.attributeId.id =: attributeId ").setParameter("productId", orderModel.getProductId()).setParameter("attributeId" , curAttrId);

        int userId = queryUserId.getSingleResult();
        int curQuantity = Integer.valueOf(queryProductQuantity.getSingleResult());
        int newQuantity = curQuantity - 1;


        Query<Integer> queryParamId =  session.createQuery("select p.parameterId "
                + " from com.company.model.Parameters p "
                + " where p.objectId.objectId = :productId and p.attributeId.id =: attributeId ").setParameter("productId", orderModel.getProductId()).setParameter("attributeId" , curAttrId);
        int curParamId = queryParamId.getSingleResult();

        if (newQuantity < 0) {
            transaction.rollback();
            return false;
        }

        Parameters parameters = session.find(Parameters.class, curParamId);
        parameters.setValue(String.valueOf(newQuantity));

        Objects userIdObj = session.get(Objects.class, userId);
        Objects productIdObj = session.get(Objects.class, orderModel.getProductId());
        Orders orders = new Orders();
        orders.setUser(userIdObj);
        orders.setProduct(productIdObj);
        session.save(orders);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Product> getOrder(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Integer> queryUserId =  session.createQuery("select p.objectId.objectId "
                + " from com.company.model.Parameters p "
                + " where p.value = :username").setParameter("username", username);
        Integer userId = queryUserId.getSingleResult();
        List<Product> products = (List<Product>) session.createQuery("select new com.company.model.Product(o.product.objectId, o.product.objectName, o.product.objectType.typeName, o.id ) from Orders o " +
                "where o.user.objectId = :userId").setParameter("userId", userId ).list();

        for (int i = 0; i < products.size(); i++ ) {

            Integer product = products.get(i).getObjectId();
            Query<String> queryPriceProduct = session.createQuery("select p.value "
                    + " from com.company.model.Parameters p "
                    + " where p.attributeId.attributeName = :price and p.objectId.objectId = :product").setParameter("price", "Price").setParameter("product", product);
            String price = queryPriceProduct.getSingleResult();
            products.get(i).setPrice(Integer.valueOf(price));
        }

        session.close();
        return products;
    }

    @Override
    public boolean delete(Integer productId, Integer orderId, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            Query<Integer> queryUserId =  session.createQuery("select p.objectId.objectId "
                    + " from com.company.model.Parameters p "
                    + " where p.value = :username").setParameter("username", email);
            int userId = queryUserId.getSingleResult();
            Query queryDelete = session.createQuery("delete from Orders o " +
                "where o.product.objectId = :productId and o.user.objectId = :userId and o.id =: orderId")
                .setParameter("productId", productId )
                .setParameter("userId", userId )
                .setParameter("orderId", orderId );

            int rowCount = queryDelete.executeUpdate();

            Query<Integer> queryProductAttributeId=  session.createQuery("select a.id "
                    + " from com.company.model.Attributes a "
                    + " where a.attributeName = :attributeName ").setParameter("attributeName", "Quantity");
            int curAttrId = queryProductAttributeId.getSingleResult();

            Query<String> queryProductQuantity =  session.createQuery("select p.value "
                    + " from com.company.model.Parameters p "
                    + " where p.objectId.objectId = :productId and p.attributeId.id =: attributeId ").setParameter("productId", productId).setParameter("attributeId" , curAttrId);

            int curQuantity = Integer.valueOf(queryProductQuantity.getSingleResult());
            int newQuantity = curQuantity + 1;


            Query<Integer> queryParamId =  session.createQuery("select p.parameterId "
                    + " from com.company.model.Parameters p "
                    + " where p.objectId.objectId = :productId and p.attributeId.id =: attributeId ").setParameter("productId", productId).setParameter("attributeId" , curAttrId);
            int curParamId = queryParamId.getSingleResult();

            Parameters parameters = session.find(Parameters.class, curParamId);
            parameters.setValue(String.valueOf(newQuantity));

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
