package com.RestApi.SpringMaven.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import com.RestApi.SpringMaven.EntityClass.EmployeeEntity;


public interface EmployeeEntityDao extends JpaRepository<EmployeeEntity, Long>{
    
     
}
