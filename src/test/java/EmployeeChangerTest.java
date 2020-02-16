import model.Employee;
import model.EmployeeDAO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmployeeChangerTest {

    @Test
    public void getEmployeesFromEmployeeDAOS() {

        ArrayList<EmployeeDAO> employeeDAOS = new ArrayList<>();
        employeeDAOS.add(new EmployeeDAO(1,"Anna","Snow","Teacher","123,00"));
        employeeDAOS.add(new EmployeeDAO(2,"Mark","Sun","Policeman","3000.00"));
        employeeDAOS.add(new EmployeeDAO(3,"Stephen","Cloud","Director","100,99"));

        ArrayList<Employee> employees = EmployeeChanger.getEmployeesFromEmployeeDAOS(employeeDAOS);

        assertEquals(1,employees.get(0).getId());
        assertEquals("Anna",employees.get(0).getName());
        assertEquals("Snow",employees.get(0).getSurname());
        assertEquals("Teacher",employees.get(0).getJob());
        assertEquals(BigDecimal.valueOf(123.00),employees.get(0).getSalary());

        assertEquals(2,employees.get(1).getId());
        assertEquals("Mark",employees.get(1).getName());
        assertEquals("Sun",employees.get(1).getSurname());
        assertEquals("Policeman",employees.get(1).getJob());
        assertEquals(BigDecimal.valueOf(3000.00),employees.get(1).getSalary());

        assertEquals(3,employees.get(2).getId());
        assertEquals("Stephen",employees.get(2).getName());
        assertEquals("Cloud",employees.get(2).getSurname());
        assertEquals("Director",employees.get(2).getJob());
        assertEquals(BigDecimal.valueOf(100.99),employees.get(2).getSalary());

    }
}