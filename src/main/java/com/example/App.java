package com.example;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;
import com.example.util.HibernateSessionUtil;
import com.example.util.Utils;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Create");

            Employee emp1 = new Employee();
            emp1.setName("Mark");
            emp1.setUnit("BBB");
            emp1.setBaseLocation("Texas");
            EmployeeDAO.addEmployee(emp1);
            Employee emp2 = new Employee();
            emp2.setName("John");
            emp2.setUnit("AAA");
            emp2.setEmail("john_aaa@company.com");
            emp2.setBaseLocation("Texas");
            EmployeeDAO.addEmployee(emp2);


            System.out.println("Show All");
            Utils.displayAllEmployees(EmployeeDAO.retreiveAllEmployees());

            System.out.println("Show one");
            Employee employee = EmployeeDAO.retreiveEmployee(1);
            System.out.println(employee);

            System.out.println("Update....");
            employee.setEmail("Rajj_aaa@company.com");
            EmployeeDAO.updateEmployeeRecord(employee);
            Employee updatedEmployee = EmployeeDAO.retreiveEmployee(1);
            System.out.println(employee);


            System.out.println("Show All");
            Utils.displayAllEmployees(EmployeeDAO.retreiveAllEmployees());

        } catch (Exception exc) {
            System.out.println("Exception in Main : " + exc.getMessage());
            exc.printStackTrace();
        } finally {
            HibernateSessionUtil.getSessionFactory().close();
        }

    }
}
