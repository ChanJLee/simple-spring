package com.chan.payroll.controller;

import com.chan.payroll.bean.Employee;
import com.chan.payroll.expection.EmployeeNotFoundException;
import com.chan.payroll.jpa.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class PayrollController {
    private EmployeeRepository mEmployeeRepository;

    public PayrollController(EmployeeRepository employeeRepository) {
        mEmployeeRepository = employeeRepository;
    }

    @RequestMapping("/payrolls")
    public List<Employee> list() {
        return mEmployeeRepository.findAll();
    }

    @GetMapping("/payrolls/{id}")
    public Employee find(@PathVariable Long id) throws Throwable {
        return mEmployeeRepository.findById(id)
                .orElseThrow((Supplier<Throwable>) EmployeeNotFoundException::new);
    }
}
