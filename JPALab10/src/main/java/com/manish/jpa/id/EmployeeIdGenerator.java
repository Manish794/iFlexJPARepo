package com.manish.jpa.id;

import com.manish.jpa.entity.Employee;
import com.manish.jpa.entity.EmployeeId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;


public class EmployeeIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        Employee employee = (Employee) obj;
        EmployeeId id = employee.getId();
        if(null == id || null == id.getBranch() || id.getBranch().trim().length() == 0) {
            throw new IllegalArgumentException("BranchCode is required");
        }
        String branchCode = id.getBranch();

        // Fetch Max id from table
        Query query= session.createQuery("SELECT max(emp.id.empId) from Employee emp where emp.id.branch=?1");
        query.setParameter(1, branchCode);
        List list = query.getResultList();
        // Handle for first value
        if (null == list || list.size() == 0 || list.get(0) == null) {
            return new EmployeeId(branchCode, 1);
        }
        Integer lastId = (Integer) list.get(0);
        return new EmployeeId(branchCode, ++lastId);
    }
}
