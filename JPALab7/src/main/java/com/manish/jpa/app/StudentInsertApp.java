package com.manish.jpa.app;

import com.manish.jpa.entity.Address;
import com.manish.jpa.entity.Student;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class StudentInsertApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Student student = new Student();
            student.setName("Kumar");
            student.setEmail("k1@tbaba.com");
            student.setPhone(888882);

            Address add1 = new Address();
            add1.setStreet("STR1");
            add1.setCity("CTY1");
            add1.setPin(999999);
            add1.setStudent(student);

            Address add2 = new Address();
            add2.setStreet("STR2");
            add2.setCity("CTY2");
            add2.setPin(888888);
            add2.setStudent(student);

            entityManager.persist(student);
            entityManager.persist(add1);
            entityManager.persist(add2);
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
