import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by wallacekwan on 2016-07-07.
 */
public class CSV {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header (Enter own values)
    private String FILE_HEADER = "";



    public boolean checkForFile(String tableName) {

        boolean existingFile = false;

        if (new File("c:\\" + "" + tableName + "" + ".csv").exists()) {

            existingFile = true;

            //read from file

            System.out.println(FILE_HEADER);

        }

        return existingFile;

    }

    public String[] readFromFile(String filePath) {
        String line = "";
        String cvsSplitBy = ",";
        String[] x = {};

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {

                x = line.split(cvsSplitBy);

                for (int i = 0; i < x.length; i++) {
                    System.out.println("test print: " + x[i]);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return x;
    }

    public void createNewFile(String filePath, String tableName, HashMap<String, String> fieldNames) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

            for (Map.Entry<String, String> entry : fieldNames.entrySet()) {

                System.out.println(entry.getKey() + " / " + entry.getValue());
                FILE_HEADER += entry.getKey() + " - " + entry.getValue() + "" + COMMA_DELIMITER + " ";

            }

            bw.append(FILE_HEADER);

            bw.newLine();
            bw.append("wallace");

            // DON'T FORGET
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
