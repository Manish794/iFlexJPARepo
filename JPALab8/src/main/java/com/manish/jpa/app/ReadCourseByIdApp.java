package com.manish.jpa.app;

import com.manish.jpa.entity.Course;
import com.manish.jpa.entity.Student;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ReadCourseByIdApp {

    public static void main(String[] args) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        Course course = null;
        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            course = entityManager.find(Course.class, 1);
            if(null != course){
                System.out.println(course.getId()+"\t"+course.getName());
                List<Student> students =  course.getStudents();
                if(null != students) {
                    for (Student student : students) {
                        System.out.println(student.getId()+"\t"+student.getName());
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
