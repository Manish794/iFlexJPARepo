package com.manish.jpa.app;

import com.manish.jpa.entity.CurrentStudent;
import com.manish.jpa.entity.OldStudent;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class OldStudentInsertApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            OldStudent student = new OldStudent();
            student.setName("Raj");
            student.setEmail("raj@tbaba.com");
            student.setPhone(9999994);

            student.setJoiningYear("2022");
            student.setDateOfCompletion(new Date());

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
