package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionUtil {

    private static SessionFactory sessionFactory;

    static {
        createSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static void createSessionFactory() {
        try {
            Configuration hibernateConfig = new Configuration();
            hibernateConfig.configure("hibernate.cfg.xml");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(hibernateConfig.getProperties()).build();

            sessionFactory = hibernateConfig.buildSessionFactory(serviceRegistry);

        }catch (Exception exc)  {
            System.out.println("Exception in SessionFactory Creation : "+exc.getMessage());
        }
    }

}
