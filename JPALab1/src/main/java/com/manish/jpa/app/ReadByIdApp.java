package com.manish.jpa.app;

import com.manish.jpa.entity.Employee;
import com.manish.jpa.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class ReadByIdApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Employee employee = entityManager.find(Employee.class, 2);
            if(null != employee) {
                System.out.println(employee);
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
