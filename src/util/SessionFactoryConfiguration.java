/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import course.work.entity.CustomerEntity;
import course.work.entity.ReservationEntity;
import course.work.entity.RoomCategoryEntity;
import course.work.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ASUS
 */
public class SessionFactoryConfiguration {
    
    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    
    private SessionFactory sessionFactory;
    
    private SessionFactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(ReservationEntity.class)
                .addAnnotatedClass(CustomerEntity.class)
                .addAnnotatedClass(RoomCategoryEntity.class)
                .addAnnotatedClass(RoomEntity.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    
    public static SessionFactoryConfiguration getInstance() {
        if (sessionFactoryConfiguration == null) {
            sessionFactoryConfiguration = new SessionFactoryConfiguration();
        }
        
        return sessionFactoryConfiguration;
    }
    
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
