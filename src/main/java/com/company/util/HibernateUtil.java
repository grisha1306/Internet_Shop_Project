package com.company.util;

import com.company.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Attributes.class);
                configuration.addAnnotatedClass(Objects.class);
                configuration.addAnnotatedClass(Parameters.class);
                configuration.addAnnotatedClass(References.class);
                configuration.addAnnotatedClass(ObjectsType.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}






//    private static StandardServiceRegistry registry;
//    private static SessionFactory sessionFactory;
//
//    public static SessionFactory getSessionFactory() {
//        //реализация синглтона. Если объекта нет - создаем, если есть просто возвращаем
//        if (sessionFactory == null) {
//            try {
//                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
//
//                //стандартные настройки для хибернат
//                //для тех, кто использует другую базу данных нужно заметить поле DRIVER, DIALECT и кусок URL легко гуглятся под любую базу
//                Map<String, String> settings = new HashMap<>();
//                settings.put(Environment.DRIVER, "org.postgresql.Driver");
//                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/dbInternetShop");
//                settings.put(Environment.USER, "postgres");
//                settings.put(Environment.PASS, "postgres");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
//
//                registryBuilder.applySettings(settings);
//
//                registry = registryBuilder.build();
//
//                MetadataSources sources = new MetadataSources(registry);
//                sources.addAnnotatedClass(Attributes.class);
//                Metadata metadata = sources.getMetadataBuilder().build();
//
//                sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                if (registry != null) {
//                    StandardServiceRegistryBuilder.destroy(registry);
//                }
//            }
//        }
//        return sessionFactory;
//    }
//
//    public static void close() {
//        if (registry != null) {
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
//    }
//}