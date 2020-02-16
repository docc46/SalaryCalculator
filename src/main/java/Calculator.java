import model.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    /*
    Adds up salaries by Job title from an <Employee> ArrayList
     */
    public Map<String, BigDecimal> getSalariesSummary(ArrayList<Employee> employees) {
        Map<String, BigDecimal> salaries = new HashMap<>();

        for (Employee employee : employees) {
            if (salaries.containsKey(employee.getJob())) {
                salaries.put(employee.getJob(), salaries.get(employee.getJob()).add(employee.getSalary()));
            } else {
                salaries.put(employee.getJob(), employee.getSalary());
            }
        }
        return salaries;
    }

}
