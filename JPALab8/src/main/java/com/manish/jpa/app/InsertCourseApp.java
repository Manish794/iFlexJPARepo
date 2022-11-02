package com.manish.jpa.app;

import com.manish.jpa.entity.Course;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class InsertCourseApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Course course1 = new Course();
            course1.setName("Java");
            course1.setDuration("3 Month");
            course1.setFee(15000);
            entityManager.persist(course1);

            Course course2 = new Course();
            course2.setName("JPA");
            course2.setDuration("15 Days");
            course2.setFee(10000);
            entityManager.persist(course2);

            Course course3 = new Course();
            course3.setName("JPA");
            course3.setDuration("20 Days");
            course3.setFee(25000);
            entityManager.persist(course3);

            transaction.commit();
            System.out.println("Data is inserted");
        }catch(Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        } finally{
            if(null != entityManager){
                entityManager.close();
            }
        }
    }
}
