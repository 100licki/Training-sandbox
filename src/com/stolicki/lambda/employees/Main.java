package com.stolicki.lambda.employees;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {


        Employee john = new Employee("John Doe", 33);
        Employee tom = new Employee("Tom EEEoe", 39);
        Employee ron = new Employee("Ron Down", 21);
        Employee professor = new Employee("Professor Car", 66);
        Employee red = new Employee("Red RidingHood", 45);
        Employee sam = new Employee("Sam Rover", 29);


        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tom);
        employees.add(ron);
        employees.add(professor);
        employees.add(red);
        employees.add(sam);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for (Employee employee : employees) {
            if (random1.nextBoolean()) {
                System.out.println(getName(getFirstName, employee));
            } else {
                System.out.println(getName(getLastName, employee));
            }
        }

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function<Employee, String> chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

    }

    private static String getName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);

//        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
//        printEmployeesByAge(employees, "\nEmployees under 30", employee -> employee.getAge() < 30);
//        printEmployeesByAge(employees, "\nEmployees under 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge() < 25;
//            }
//        });
//
//        IntPredicate greaterThan15 = i -> i > 15;
//        IntPredicate lessThan100 = i -> i < 100;
//        System.out.println(greaterThan15.test(10));
//        int a = 20;
//        System.out.println(greaterThan15.test(a + 5));
//
//        System.out.println(greaterThan15.and(lessThan100).test(50));
//        System.out.println(greaterThan15.and(lessThan100).test(15));
//
//        Random random = new Random();
//        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(randomSupplier.get()));
//        }
//
//        employees.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
//            System.out.println("Last Name is: " + lastName);
//        });
    }

    private static void printEmployeesByAge(@NotNull List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("==========");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
