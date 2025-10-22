package org.example.GenericsStreamsLambda;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank","Adam");

    List<Integer> numbers = List.of(10, 25, 33, 47, 50, 68, 72, 89, 91);

    List<Employee> employees = List.of(
            new Employee("John", 50000),
            new Employee("Jane", 60000),
            new Employee("Jake", 75000),
            new Employee("Emily", 90000),
            new Employee("Mike", 120000)
    );

    public List<String> getNamesStartingWithA() {
        List<String> namesList = names.stream()
                .filter(name -> name.startsWith("A"))
                .toList();

        return namesList;
    }

    public List<Integer> getNumbersGreaterThan50() {
        List<Integer> numbersList = numbers.stream()
                .filter(number -> number > 50)
                .toList();

        return numbersList;
    }

    public List<String> uppercaseNames() {
        List<String> uppercaseNamesList = names.stream()
                .map(name -> name.toUpperCase())
                .toList();

        return uppercaseNamesList;
    }

    public List<Integer> getLengthOfNames(){
        List<Integer> lengthList = names.stream()
                .map(name -> name.length())
                .toList();

        return lengthList;
    }

    public List<Integer> getEmployeeSalary() {
        List<Integer> salaryList = employees.stream()
                .map(employee -> employee.getSalary())
                .toList();

        return salaryList;
    }

    public List<Employee> sortEmployeeBySalary() {
        List<Employee> employeesBySalaryList = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();

        return employeesBySalaryList;
    }

    public Map<String, List<Employee>> groupEmployeeBySalary() {
        Map<String, List<Employee>> groupedEmployees = employees.stream()
                .collect(Collectors.groupingBy(emp -> {
                    if (emp.getSalary() < 60000) return "Below 60,000";
                    else if (emp.getSalary() <= 100000) return "60,000 - 100,000";
                    else return "Above 100,000";
                }));
        return groupedEmployees;
    }
}
