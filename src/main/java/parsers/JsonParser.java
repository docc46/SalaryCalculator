package parsers;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.EmployeeDAO;
import model.EmployeesFromJson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class JsonParser {

    private Gson gson = new Gson();

    /*
    Parses json file to <EmployeeDAO> ArrayList
     */
    public ArrayList<EmployeeDAO> getEmployeesFromFile(File file) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(file));
        EmployeesFromJson employeesFromJson = gson.fromJson(reader, EmployeesFromJson.class);
        return employeesFromJson.getEmployees();
    }

}
