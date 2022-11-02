package com.manish.jpa.app;

import com.manish.jpa.entity.Login;
import com.manish.jpa.entity.Student;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentLoginInsertApp {

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
            student.setPhone(888888882L);

            Login login = new Login();
            login.setUsername("kumar@99");
            login.setPassword("@@kumar@@");
            login.setRole("STUDENT");

            student.setUserLogin(login);

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
