package com.example.dao;

import com.example.model.Employee;
import com.example.util.HibernateSessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDAO {

    public static void addEmployee(Employee employee)   {
        Session session = HibernateSessionUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(employee);

        session.getTransaction().commit();
        session.close();
    }

    public static Employee retreiveEmployee(int id) {
        Session session = HibernateSessionUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String queryString = "from EMPLOYEE where EMPLOYEE_ID = :empId";
        Query query = session.createQuery(queryString);
        query.setInteger("empId", id);
        Employee employee = (Employee) query.uniqueResult();

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    public static List<Employee> retreiveAllEmployees() {
        Session session = HibernateSessionUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Employee> employees = session.createQuery("from EMPLOYEE").list();

        session.getTransaction().commit();
        session.close();

        return employees;
    }

    public static void updateEmployeeRecord(Employee employee)  {
        Session session = HibernateSessionUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(employee);

        session.getTransaction().commit();
        session.close();
    }

    public static void deleteEmployeeRecord(int id)  {
        Session session = HibernateSessionUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String queryString = "from EMPLOYEE where EMPLOYEE_ID = :empId";
        Query query = session.createQuery(queryString);
        query.setInteger("empId", id);
        Employee employee = (Employee) query.uniqueResult();
        session.delete(employee);

        session.getTransaction().commit();
        session.close();
    }

    public static void deleteAll()  {
        Session session = HibernateSessionUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Employee> employees = session.createQuery("from EMPLOYEE").list();
        for(Employee employee : employees)  {
            session.delete(employee);
        }

        session.getTransaction().commit();
        session.close();
    }

}
