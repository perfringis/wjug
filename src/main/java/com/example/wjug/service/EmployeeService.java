package com.example.wjug.service;

import com.example.wjug.dao.Employee;
import com.example.wjug.dao.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public Employee createNew(String firstName, String lastName, BigDecimal hourlyEarnings) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setHourlyEarnings(hourlyEarnings);
        employee.setId(UUID.randomUUID());
        return employeeRepository.save(employee);
    }

    @Transactional
    public void addNewTimesheet(UUID employeeId, int hours) {
        Employee employee = employeeRepository.getById(employeeId);
        if (employee.getLastNotSettledTimesheetWorkTime() != null) {
            throw new IllegalArgumentException("You need to first add the invoice");
        }
        employee.setLastNotSettledTimesheetWorkTime(hours);
    }
}
