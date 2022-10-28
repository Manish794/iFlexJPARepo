package com.manish.jpa.app;

import com.manish.jpa.entity.Employee;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class InsertApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            Employee employee = Employee.builder()
                    .name("Rahul")
                    .email("rahul@tbaba.com")
                    .phone(12345678L)
                    .doj(new Date())
                    .build();

            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
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
