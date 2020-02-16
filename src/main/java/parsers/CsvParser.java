package parsers;

import model.EmployeeDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class CsvParser {

    /*
    Parses CSV file to <EmployeeDAO> ArrayList
     */
    public ArrayList<EmployeeDAO> getEmployeesFromFile(File file) throws IOException {
        ArrayList<EmployeeDAO> employees = new ArrayList<>();

        Reader reader = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().withIgnoreSurroundingSpaces().parse(reader);

        for (CSVRecord record : records) {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            employeeDAO.setId(Integer.parseInt(record.get("id")));
            employeeDAO.setName(record.get("name"));
            employeeDAO.setSurname(record.get("surname"));
            employeeDAO.setJob(record.get("job"));
            employeeDAO.setSalary(record.get("salary"));
            employees.add(employeeDAO);
        }

        return employees;
    }
}
