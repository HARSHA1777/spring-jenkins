package com.employee.service;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;

@Service
public class EmployeeService {
	   private final Map<Integer, Employee> employees = new HashMap<>();

	    
	   public Employee addEmployee(Employee employee) {
		    logger.info("Adding employee with code: {}",
		            employee.getEmpCode());

		    employees.put(employee.getEmpCode(), employee);

		    logger.info("Employee added successfully");
		    return employee;
		}
	    
	    public Employee updateEmployee(Employee employee) {
	    	 int empCode = employee.getEmpCode();
          if (!employees.containsKey(empCode)) {
	             return null;
	         }
           employees.put(empCode, employee);
	         return employee;
	    }
	    
	    public boolean deleteEmployee(int empCode) {
	    	return employees.remove(empCode) != null;
	    }
}
