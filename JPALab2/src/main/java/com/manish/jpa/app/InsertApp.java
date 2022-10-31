package com.manish.jpa.app;

import com.manish.jpa.entity.Student;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InsertApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Student student = new Student();
            student.setName("Kumar");
            student.setEmails(List.of("k1@tbaba.com", "k2@baba.com"));
            student.setPhones(Set.of(99999102L, 88888102L, 77777102L));
            student.setMarks(Map.of("Java", 56, "Spring", 98));

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
