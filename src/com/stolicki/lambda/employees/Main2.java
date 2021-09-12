package com.stolicki.lambda.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee jack = new Employee("Jack Deer", 25);
        Employee jane = new Employee("Jane Wok", 66);
        Employee snow = new Employee("Snow Rat", 45);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(jack);
        hr.addEmployee(jane);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(snow);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((employee, employee2) -> employee.getAge() < employee2.getAge() ? employee : employee2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
    }
}
