package com.manish.jpa.app;

import com.manish.jpa.entity.Course;
import com.manish.jpa.entity.Student;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ReadStudentByIdApp {

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
                System.out.println(student.getId()+"\t"+student.getName());
                List<Course> courses =  student.getCourses();
                if(null != courses) {
                    for (Course course : courses) {
                        System.out.println("\t"+course.getId()+"\t"+course.getName());
                    }
                }
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
