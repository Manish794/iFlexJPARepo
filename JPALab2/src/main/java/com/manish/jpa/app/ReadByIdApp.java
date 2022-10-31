package com.manish.jpa.app;

import com.manish.jpa.entity.Student;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadByIdApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        Student student = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            student = entityManager.find(Student.class, 1);
            if(null != student){
                System.out.println("Sid "+student.getId());
                System.out.println("Name "+student.getName());
                System.out.println("Marks "+student.getMarks());
                System.out.println("Phones "+student.getPhones());
            } else {
                System.out.println("No Record Found");
            }
            transaction.commit();
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
        System.out.println("Phones "+student.getPhones());
        // System.out.println("Emails "+student.getEmails());
    }
}
