package com.manish.jpa.app;

import com.manish.jpa.entity.CurrentStudent;
import com.manish.jpa.entity.Student;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CStudentInsertApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            CurrentStudent student = new CurrentStudent();
            student.setName("Rahul");
            student.setEmail("rahul@tbaba.com");
            student.setPhone(9999992);

            student.setTiming("6-8 PM");
            student.setBatch("B32");

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
