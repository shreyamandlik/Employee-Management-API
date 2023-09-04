package com.RestApi.SpringMaven.Repository;

import java.util.List;

import com.RestApi.SpringMaven.EntityClass.EmployeeEntity;

public interface EmployeeInterface {
     public List<EmployeeEntity> getAllEmployee();
     
     public EmployeeEntity getEmployee(long empId);

     public EmployeeEntity addEmployee(EmployeeEntity emp);

     public EmployeeEntity updateEmployee(EmployeeEntity emp);

      public EmployeeEntity updateEmployeebyID(long empId,EmployeeEntity updatedEmployee);

     public void deleteEmployee(long parseLong);

}
