package com.example.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class Employee {
    @Id
    @GeneratedValue(generator = "EMPLOYEE_ID_SEQUENCE", strategy = GenerationType.SEQUENCE)
    @Column(name = "EMPLOYEE_ID", unique = true)
    private int id;

//    @Column(name = "EMPLOYEE_ID")
//    private String employeeId;

    @Column
    private String name;

    @Column
    private String unit;

    @Column(name = "BASE_LOCATION")
    private String baseLocation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }
}
