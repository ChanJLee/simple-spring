package com.chan.payroll.config;

import com.chan.payroll.bean.Employee;
import com.chan.payroll.jpa.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayrollConfig {

    @Bean
    CommandLineRunner init(EmployeeRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                for (int i = 0; i < 10; ++i) {
                    repository.save(new Employee("lee" + i, "jiacheng"));
                }
            }
        };
    }
}
