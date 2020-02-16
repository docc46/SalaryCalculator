package model;

import java.util.ArrayList;

public class EmployeesFromJson {

    private ArrayList<EmployeeDAO> employees = new ArrayList<>();

    public EmployeesFromJson() {
    }

    public EmployeesFromJson(ArrayList<EmployeeDAO> employees) {
        this.employees = employees;
    }

    public ArrayList<EmployeeDAO> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<EmployeeDAO> employees) {
        this.employees = employees;
    }
}
