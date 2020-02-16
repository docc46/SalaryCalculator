import model.Employee;
import model.EmployeeDAO;
import parsers.CsvParser;
import parsers.JsonParser;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        JsonParser jsonParser = new JsonParser();
        CsvParser csvParser = new CsvParser();
        Calculator calculator = new Calculator();
        ResultWriter resultWriter = new ResultWriter();

        File employeesJson = new File(System.getProperty("user.dir"), "employees.json");
        File employeesCsv = new File(System.getProperty("user.dir"), "employees.csv");

        ArrayList<EmployeeDAO> employeeDAOSFromJson = jsonParser.getEmployeesFromFile(employeesJson);
        ArrayList<EmployeeDAO> employeeDAOSFromCSV = csvParser.getEmployeesFromFile(employeesCsv);

        ArrayList<Employee> employeesFromJson = EmployeeChanger.getEmployeesFromEmployeeDAOS(employeeDAOSFromJson);
        ArrayList<Employee> employeesFromCSV = EmployeeChanger.getEmployeesFromEmployeeDAOS(employeeDAOSFromCSV);

        Map<String, BigDecimal> salariesFromJson = calculator.getSalariesSummary(employeesFromJson);
        Map<String, BigDecimal> salariesFromCSV = calculator.getSalariesSummary(employeesFromCSV);

        resultWriter.writeSalariesToFile(salariesFromJson, "salaries_from_json.txt");
        resultWriter.writeSalariesToFile(salariesFromCSV, "salaries_from_csv.txt");
    }

}
