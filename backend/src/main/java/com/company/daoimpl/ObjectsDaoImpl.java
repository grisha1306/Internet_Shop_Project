package com.company.daoimpl;

import com.company.dao.GenericDao;
import com.company.model.Objects;
import com.company.model.Product;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("unchecked")
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
        List<Product> products = (List<Product>) session.createQuery("select new com.company.model.Product(o.objectId, o.objectName, o.objectType.typeName) from Objects o where objectType.typeName != 'user'").list();

//        Query<Integer> queryProductAttributeId=  session.createQuery("select a.id "
//                + " from com.company.model.Attributes a "
//                + " where a.attributeName = :attributeName ").setParameter("attributeName", "Quantity");
//        int curAttrId = queryProductAttributeId.getSingleResult();

        for (int i = 0; i < products.size(); i ++) {
            Query<String> queryQuantity =  session.createQuery("select p.value "
                    + " from com.company.model.Parameters p "
                    + " where p.objectId.objectId =: objectId and p.attributeId.attributeName =: attributeName").setParameter("objectId", products.get(i).getObjectId())
                    .setParameter("attributeName", "Quantity");
            int curQuantity = Integer.parseInt(queryQuantity.getSingleResult());
            products.get(i).setQuantity(curQuantity);
        }

        session.close();
        return products;
    }

}
