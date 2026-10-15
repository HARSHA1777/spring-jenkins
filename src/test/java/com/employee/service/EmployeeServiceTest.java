package com.employee.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.entity.Employee;

class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee(101, "Harsha", 45000);
        Employee result = employeeService.addEmployee(employee);
        assertNotNull(result);
        assertEquals(101, result.getEmpCode());
        assertEquals("Harsha", result.getEmpName());
        assertEquals(45000, result.getEmpSalary(), 0.001);
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee(101, "Harsha", 45000);
        employeeService.addEmployee(employee);
        Employee updatedEmployee =
                new Employee(101, "Harsha Updated", 50000);
        Employee result =
                employeeService.updateEmployee(updatedEmployee);
        assertNotNull(result);
        assertEquals("Harsha Updated", result.getEmpName());
        assertEquals(50000, result.getEmpSalary(), 0.001);
    }

    @Test
    void testUpdateEmployeeNotFound() {
        Employee employee =
                new Employee(999, "Unknown", 30000);
        Employee result =
                employeeService.updateEmployee(employee);
        assertNull(result);
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = new Employee(101, "Harsha", 45000);
        employeeService.addEmployee(employee);
        boolean result = employeeService.deleteEmployee(101);
        assertTrue(result);
    }

    @Test
    void testDeleteEmployeeNotFound() {
        boolean result = employeeService.deleteEmployee(999);
        assertFalse(result);
    }
}