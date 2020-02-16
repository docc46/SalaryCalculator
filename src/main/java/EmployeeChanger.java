import model.Employee;
import model.EmployeeDAO;

import java.math.BigDecimal;
import java.util.ArrayList;

public class EmployeeChanger {

    /*
    Produces an ArrayList of 'BigDecimal salary' employees from an ArrayList of 'String salary' employees
     */
    public static ArrayList<Employee> getEmployeesFromEmployeeDAOS(ArrayList<EmployeeDAO> employeeDAOS) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (EmployeeDAO employeeDAO : employeeDAOS) {
            Employee employee = new Employee(
                    employeeDAO.getId(),
                    employeeDAO.getName(),
                    employeeDAO.getSurname(),
                    employeeDAO.getJob(),
                    BigDecimal.valueOf(Double.parseDouble(employeeDAO.getSalary().replaceAll(",", ".")))
            );
            employees.add(employee);
        }
        return employees;
    }

}
