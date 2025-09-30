package org.example;

import org.example.GenericsCollectionsStreamsLambda.Employee;
import org.example.GenericsCollectionsStreamsLambda.Streams;
import org.example.Exceptions.CustomException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws CustomException {
        System.out.println("Hello world!");
        Streams streams = new Streams();

        List<Employee> list = streams.sortEmployeeBySalary().stream().toList();

        list.forEach(employee -> System.out.println("Name: " + employee.getName() + " Salary: " + employee.getSalary()));
//        System.out.println(list.toString());
    }
}
