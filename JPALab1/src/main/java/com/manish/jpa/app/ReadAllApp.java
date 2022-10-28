package com.manish.jpa.app;

import com.manish.jpa.entity.Employee;
import com.manish.jpa.util.JPAUtil;
import javax.persistence.*;
import java.util.List;

public class ReadAllApp {
    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createQuery("SELECT em from Employee em", Employee.class);
            List<Employee> employees =  query.getResultList();
            if(null != employees) {
                for(Employee employee : employees){
                    System.out.println(employee);
                }
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
