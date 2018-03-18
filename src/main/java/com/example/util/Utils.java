package com.example.util;

import com.example.model.Employee;

import java.util.List;

public class Utils {

    public static void displayAllEmployees(List<Employee> employees)    {
        System.out.println("EmployeeID\t\tName\t\tMail\t\tLocation\t\tUnit");
        for (Employee employee: employees) {
            System.out.println(employee.getId()+"\t\t"+employee.getName()+"\t\t"+employee.getEmail()+"\t\t"+employee.getBaseLocation()+"\t\t"+employee.getUnit());
        }
    }

}
