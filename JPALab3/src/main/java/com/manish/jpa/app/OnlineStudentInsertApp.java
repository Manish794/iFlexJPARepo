package com.manish.jpa.app;

import com.manish.jpa.entity.OldStudent;
import com.manish.jpa.entity.OnlineStudent;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class OnlineStudentInsertApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            OnlineStudent student = new OnlineStudent();
            student.setName("Rohan");
            student.setEmail("roh@tbaba.com");
            student.setPhone(9999995);

            student.setTiming("7-9 PM");
            student.setBatch("B33");

            student.setLink("https://abc.com");
            student.setPassCode("abc234");

            entityManager.persist(student);
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
