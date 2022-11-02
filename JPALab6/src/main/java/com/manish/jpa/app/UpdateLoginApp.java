package com.manish.jpa.app;

import com.manish.jpa.entity.Login;
import com.manish.jpa.entity.Student;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UpdateLoginApp {

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
                System.out.println("Sid :" +student.getId());
                System.out.println("Name    :" +student.getName());
                System.out.println("Email   :" +student.getEmail());
                System.out.println("Phone   :" +student.getPhone());

                Login login = new Login();
                login.setUsername("manish@99");
                login.setPassword("@@manish@@");
                login.setRole("ADMIN");
                student.setUserLogin(login);
                entityManager.merge(student);
                System.out.println("Login Details updated for student "+ student.getId());
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

    }
}
