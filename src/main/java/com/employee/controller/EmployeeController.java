package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
      
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    	 		Employee addedEmployee = employeeService.addEmployee(employee);
		return ResponseEntity.ok(addedEmployee);
    }
    
    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
    	Employee updatedEmployee = employeeService.updateEmployee(employee);
    	if(updatedEmployee == null) {
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(updatedEmployee);
    }
    
    @DeleteMapping("/deleteEmployee/{empCode}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empCode){
		boolean isDeleted = employeeService.deleteEmployee(empCode);
		if(!isDeleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok("Employee deleted successfully");
	}
    
}
