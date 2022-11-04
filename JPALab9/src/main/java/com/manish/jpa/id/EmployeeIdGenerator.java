package com.manish.jpa.id;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.List;


public class EmployeeIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
       return generateWithSomePattern(session);
    }

    private String generateWithSomePattern(SharedSessionContractImplementor session){
        String newId = "E-001";

        // Fetch Max id from table
        List list = session.createQuery("SELECT max(emp.id) from Employee emp").list();

        // Handle for first value
        if (null == list || list.size() == 0 || list.get(0) == null) {
            return newId;
        }

        String lastId = list.get(0).toString();
        int idIntPart = Integer.parseInt(lastId.substring(2));
        idIntPart++;

        if(idIntPart < 10)
            newId = "E-00"+idIntPart;
        else if (idIntPart < 100)
            newId = "E-0"+idIntPart;
        else
            newId = "E-"+idIntPart;
        return newId;
    }

    private String generateRandomId(){
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer id = new StringBuffer();
        for(int i = 0; i< 10; i++){
            int index =  (int) (Math.random() * allowedChars.length());
            id.append(allowedChars.charAt(index));
        }
        System.out.println("Generated number "+ id);
        return id.toString();
    }

}
