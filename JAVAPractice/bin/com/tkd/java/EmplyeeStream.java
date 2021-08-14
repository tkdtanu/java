package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmplyeeStream {
    public static void main(String[] args) {
        final List<Employee> savedEmployee = new ArrayList<>();
        List<Employee> employees = List.of(new Employee(1, "A", 10000),
                new Employee(2, "B", 20000),
                new Employee(3, "C", 30000),
                new Employee(4, "D", 40000),
                new Employee(5, "E", 20000),
                new Employee(6, "F", 10000),
                new Employee(7, "G", 30000));

        Map<Long, Set<Employee>> employeeMap = employees.parallelStream()
                .collect(Collectors.groupingBy(employee -> employee.salary, Collectors.toSet()));

        System.out.println(employeeMap);

        Integer a = 100;
        employees.stream()
                .filter(employee -> {
                    if (a > 100) {
                    }
                    return savedEmployee.contains(employee);
                })
                .forEach(System.out::println);
    }
}


class Employee {
    int id;
    String name;
    long salary;

    public Employee(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
