package com.aa.homework.lina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class HashmapTest {

    private static class Employee {
        private int id;
        private String firstName;
        private String lastName;
        private String role;

        public Employee(int id, String firstName, String lastName, String role) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.role = role;
        }

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getRole() {
            return role;
        }
    }

    @Test
    void hashMap() {
        // Key/Value pairs:
        //       employee ID - Employee Object

        Employee employee1 = new Employee(403954, "John", "Doe", "Programmer");
        Employee employee2 = new Employee(403958, "Joe", "Doe", "Programmer");
        Employee employee3 = new Employee(403988, "Jane", "Doe", "Programmer");
        Employee employee4 = new Employee(403999, "Junior", "Doe", "Supervisor");

        List<Employee> employees = new ArrayList<>() {{
            add(employee1);
            add(employee2);
            add(employee3);
            add(employee4);
        }};

        for (Employee employee : employees) {
            if (employee.getId() == 403999) {
                printEmployeeName(employee);
            }
        }

        //    key      value
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        printEmployeeName(employeeMap.get(403999));
    }

    private void printEmployeeName(Employee employee) {
        System.out.println("Employee's name is " + employee.getFirstName() + " " + employee.getLastName() );
    }

}
