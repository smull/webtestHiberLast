package com.levelup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by denis_zavadsky on 2/19/15.
 */
public class HibernateSessionProvider {

    private static SessionFactory sessionFactory;


    public static synchronized Session getSession(){
        if (sessionFactory == null){
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        return sessionFactory.openSession();
    }
}
