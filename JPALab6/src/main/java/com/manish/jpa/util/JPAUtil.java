package com.manish.jpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME="JPALabPersistence";
    private static EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

        private static EntityManagerFactory buildEntityManagerFactory(){
            return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

      public static EntityManagerFactory getEntityManagerFactory(){
            return entityManagerFactory;
      }
}
