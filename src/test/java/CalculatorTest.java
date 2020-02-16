import model.Employee;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {


    @Test
    public void getSalariesSummary() {

        Calculator calculator = new Calculator();

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(0, "", "", "Job1", new BigDecimal("10.10")));
        employees.add(new Employee(1, "", "", "Job1", new BigDecimal("1.45")));
        employees.add(new Employee(2, "", "", "Job1", new BigDecimal("3.45")));
        employees.add(new Employee(3, "", "", "Job2", new BigDecimal("4.99")));
        employees.add(new Employee(4, "", "", "Job2", new BigDecimal("1.99")));
        employees.add(new Employee(5, "", "", "Job3", new BigDecimal("0.00")));

        Map<String, BigDecimal> salaries = calculator.getSalariesSummary(employees);

        assertEquals(BigDecimal.valueOf(15.00).setScale(2), salaries.get("Job1"));
        assertEquals(BigDecimal.valueOf(6.98).setScale(2), salaries.get("Job2"));
        assertEquals(BigDecimal.valueOf(0.00).setScale(2), salaries.get("Job3"));
        assertEquals(null, salaries.get("Job4"));
    }
}