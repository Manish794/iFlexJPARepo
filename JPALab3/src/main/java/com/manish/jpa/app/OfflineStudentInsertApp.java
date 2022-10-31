package com.manish.jpa.app;

import com.manish.jpa.entity.OfflineStudent;
import com.manish.jpa.entity.OnlineStudent;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class OfflineStudentInsertApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            OfflineStudent student = new OfflineStudent();
            student.setName("Kumar");
            student.setEmail("k@tbaba.com");
            student.setPhone(9999993);

            student.setTiming("8-10 PM");
            student.setBatch("B34");

            student.setRoomNumber("RM-101");
            student.setSeatNo("CH-12");

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
