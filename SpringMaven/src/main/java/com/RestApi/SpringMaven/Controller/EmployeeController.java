package com.RestApi.SpringMaven.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.SpringMaven.EntityClass.EmployeeEntity;
import com.RestApi.SpringMaven.Repository.EmployeeInterface;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeInterface employeeInterface;

    /*
     * Route - /emp
     * Method - GET
     * Params - None
     * Desc - Get all employees
     */
    @GetMapping("/emp")
    public List<EmployeeEntity> getAllEmployee() {
        //get all employee data
        return this.employeeInterface.getAllEmployee();
    }

    /*
     * Route - /emp
     * Method - GET
     * Params - empId
     * Desc - Get employee based on Id
     */
    @GetMapping("/emp/{empId}")
    public ResponseEntity<Object> getEmployee(@PathVariable String empId) {
        try {
            // Parse empId to a Long
            Long employeeId = Long.parseLong(empId);
            // Check if the employee with the given ID exists
            EmployeeEntity employee = this.employeeInterface.getEmployee(employeeId);
            if (employee != null) {
                // Return the employee data as JSON
                return ResponseEntity.ok(employee);
            } else {
                // If the employee doesn't exist, return a JSON error message
                String errorMessage = "Employee with ID " + empId + " does not exist.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (NumberFormatException e) {
            // Handle the case where empId is not a valid number
            String errorMessage = "Invalid employee ID format. Please provide a valid numeric ID.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /*
     * Route - /emp/add
     * Method - POST
     * Params - None
     * Desc - Add employee
     */
    @PostMapping("/emp/add")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity emp) {
        //Add an employee data
        return this.employeeInterface.addEmployee(emp);
    }

    /*
     * Route - /emp/update
     * Method - PUT
     * Params - None
     * Desc - Update employees
     */
    @PutMapping("/emp/update")
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity emp) {
        //Update employee data
        return this.employeeInterface.updateEmployee(emp);
    }

 /*
     * Route - /emp/update
     * Method - PUT
     * Params - empId
     * Desc - Update employee based on id
     */
    @PutMapping("/emp/update/{empId}")
    public ResponseEntity<Object> updateEmployeebyID(@PathVariable String empId,
            @RequestBody EmployeeEntity updatedEmployee) {
        try {
            // Parse empId to a Long
            Long employeeId = Long.parseLong(empId);

            // Check if the employee with the given ID exists
            EmployeeEntity existingEmployee = this.employeeInterface.getEmployee(employeeId);

            if (existingEmployee != null) {
                // Update the employee's data with the new data from the request body
                existingEmployee.setFirst_name(updatedEmployee.getFirst_name());
                existingEmployee.setLast_name(updatedEmployee.getLast_name());
                existingEmployee.setEmail(updatedEmployee.getEmail());
                existingEmployee.setJob_title(updatedEmployee.getJob_title());
                existingEmployee.setContact_number(updatedEmployee.getContact_number());
                // Save the updated employee data
                EmployeeEntity updated = this.employeeInterface.updateEmployee(existingEmployee);

                // Return the updated employee data as JSON
                return ResponseEntity.ok(updated);
            } else {
                // If the employee doesn't exist, return a JSON error message
                String errorMessage = "Employee with ID " + empId + " does not exist.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (NumberFormatException e) {
            // Handle the case where empId is not a valid number
            String errorMessage = "Invalid employee ID format. Please provide a valid numeric ID.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /*
     * Route - /emp/delete
     * Method - DELETE
     * Params - empId
     * Desc - Delete employee based on id
     */
    @DeleteMapping("/emp/delete/{empId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable String empId) {
        try {
            Long employeeId = Long.parseLong(empId);

            // Attempt to delete the employee
            this.employeeInterface.deleteEmployee(employeeId);

            return ResponseEntity.ok("Employee with ID " + empId + " has been deleted.");
        } catch (NumberFormatException e) {
            // Handle the case where empId is not a valid number
            String errorMessage = "Invalid employee ID format. Please provide a valid numeric ID.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

}
