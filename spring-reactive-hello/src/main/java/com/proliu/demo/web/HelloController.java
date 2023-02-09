package com.proliu.demo.web;

import com.proliu.demo.dto.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/all")
    private Flux<Employee> getAllEmployees() {
        List<Employee> employeeList = Arrays.asList(new Employee("jack", "li", 18), new Employee("tom", "zhou", 18));

        return Flux.fromStream(employeeList.stream());
    }

}
