package com.suhail.employee_management_system.service;

import com.suhail.employee_management_system.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1, "Suhail", "suhail@gmail.com", "IT", 50000));
        employees.add(new Employee(2, "Rahul", "rahul@gmail.com", "HR", 45000));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee employee = getEmployeeById(id);

        if (employee != null) {
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
        }

        return employee;
    }

    public boolean deleteEmployee(int id) {
        return employees.removeIf(emp -> emp.getId() == id);
    }
}
