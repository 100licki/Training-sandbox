package com.stolicki.lambda;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Employee john = new Employee("John Doe", 33);
        Employee tom = new Employee("Tom EEEoe", 39);
        Employee ron = new Employee("Ron Down", 21);
        Employee professor = new Employee("Professor Car", 66);


        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tom);
        employees.add(ron);
        employees.add(professor);

//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });



//        System.out.println("XXXXXXXXXXXXXXXX");
//
//        for (int i = 0; i < employees.size(); i++) {
//            Employee employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }


//
////        Collections.sort(employees, new Comparator<Employee>() {
////            @Override
////            public int compare(Employee employee1, Employee employee2) {
////                return employee1.getName().compareTo(employee2.getName());
////            }
////        });
//
//        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
//
//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//
////        String sillyString = doStringStuff(new UpperConcat() {
////            @Override
////            public String upperAndConcat(String s1, String s2) {
////                return s1.toUpperCase() + s2.toUpperCase();
////            }
////        }, employees.get(0).getName(), employees.get(1).getName());
////        System.out.println(sillyString);
//
//        UpperConcat upperConcat = (s1, s2) -> {
//            return s1.toUpperCase() + s2.toUpperCase();
//        };
//        String sillyString = doStringStuff(upperConcat, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
//
//        AnotherClass anotherClass = new AnotherClass();
//        String s = anotherClass.doSomething();
//        System.out.println(s);
    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            System.out.println(i);
            return result;
        };

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());

        return Main.doStringStuff(uc, "String1", "String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}