package com.manish.jpa.app;

import com.manish.jpa.entity.Course;
import com.manish.jpa.entity.Student;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class StudentInsertApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createQuery("SELECT c from Course c", Course.class);
            List<Course> courses =  query.getResultList();
            if(null != courses) {
                for(Course course : courses){
                    System.out.println(course.getId()+"\t"+course.getName());
                }
            }

            Student student = new Student();
            student.setName("Rahulr");
            student.setEmail("r1@tbaba.com");
            student.setPhone(9999993);

            student.setCourses(List.of(courses.get(1), courses.get(2)));

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
