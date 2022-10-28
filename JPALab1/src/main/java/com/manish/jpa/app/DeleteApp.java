package com.manish.jpa.app;

import com.manish.jpa.entity.Employee;
import com.manish.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DeleteApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			Employee emp = entityManager.find(Employee.class, 3);
			if (null != emp) {
				entityManager.remove(emp);
				System.out.println("Record Deleted with id "+ emp.getId());
			} else {
				System.out.println("Data not found to Delete");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (null != tx)
				tx.rollback();
		} finally {
			if (null != entityManager)
				entityManager.close();
		}
	}
}
