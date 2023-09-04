package com.RestApi.SpringMaven.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.SpringMaven.DAO.EmployeeEntityDao;
import com.RestApi.SpringMaven.EntityClass.EmployeeEntity;

@Service
public class EmployeeInterfaceImpl implements EmployeeInterface {

    @Autowired
    private EmployeeEntityDao eeDao;

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return eeDao.findAll();
    }

    @Override
    public EmployeeEntity getEmployee(long empId) {
        EmployeeEntity employee = eeDao.findById(empId).orElse(null);
        return employee;
    }

    @Override
    public EmployeeEntity addEmployee(EmployeeEntity emp) {
        eeDao.save(emp);
        return emp;
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity emp) {   
            eeDao.save(emp);
            return emp;
    }
    
    @Override
    public EmployeeEntity updateEmployeebyID(long empId, EmployeeEntity updatedEmployee) {
        boolean employeeExists = eeDao.existsById(empId);       
        if (employeeExists) {          
            EmployeeEntity existingEmployee = eeDao.findById(empId).get();
            EmployeeEntity updated = eeDao.save(existingEmployee);
            return updated;
        } else {
            return null;
        }
    }

    @Override
    public void deleteEmployee(long parseLong) {
        EmployeeEntity employee = eeDao.findById(parseLong).orElse(null);
        eeDao.delete(employee);
    }  

}
