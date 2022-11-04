package com.manish.jpa.app;

import com.manish.jpa.entity.Employee;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class InsertApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Employee employee = new Employee();
            employee.setName("Manish");
            employee.setEmail("manish@tbaba.com");
            employee.setPhone(98989898L);

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

    public static class InsertCourseApp {

        public static void main(String[] args) {
            EntityManager entityManager = null;
            EntityTransaction transaction = null;
            try {
                entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
                transaction = entityManager.getTransaction();
                transaction.begin();
                Employee employee = new Employee();
                employee.setName("Manish");
                employee.setEmail("manish@tbaba.com");
                employee.setPhone(98989898L);

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

    public static class ReadStudentByIdApp {

        public static void main(String[] args) {
            EntityManager entityManager = null;
            EntityTransaction transaction = null;
            Employee employee = null;
            try {
                entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
                transaction = entityManager.getTransaction();
                transaction.begin();

                employee = entityManager.find(Employee.class, 1);
                if(null != employee){
                    System.out.println(employee.getId()+"\t"+employee.getName());
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
}
