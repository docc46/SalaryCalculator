import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class ResultWriter {

    /*
    Writes salaries map to a file
     */
    public void writeSalariesToFile(Map<String, BigDecimal> salaries, String filename) throws IOException {
        File result = new File(System.getProperty("user.dir"), filename);
        result.createNewFile();
        FileWriter fw = new FileWriter(result);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Map.Entry<String, BigDecimal> entry : salaries.entrySet()) {
            bw.write(entry.getKey() + " - " + entry.getValue().setScale(2, BigDecimal.ROUND_HALF_UP));
            bw.write("\n");
        }

        bw.close();
    }

}
