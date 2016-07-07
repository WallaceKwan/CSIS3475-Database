import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    private String FILE_HEADER = "id,firstName,lastName,gender,age";



    public boolean checkForFile(String tableName) {

        boolean existingFile = false;

        if (new File("c:\\" + "" + tableName + "" + ".csv").exists()) {

            existingFile = true;

            //read from file

            System.out.println(FILE_HEADER);

        }

        return existingFile;

    }

    public void createNewFile(String tableName, HashMap<String, String> fieldNames) {

        try {

            FileWriter writer = new FileWriter("c:\\" + "" + tableName + "" + ".csv");

            for (Map.Entry<String, String> entry : fieldNames.entrySet()) {

                System.out.println(entry.getKey() + " / " + entry.getValue());
                FILE_HEADER += entry.getKey() + " - " + entry.getValue();

            }

            writer.append("id");
            writer.append(COMMA_DELIMITER);
            writer.append("name");


            // do whatever

            System.out.println(writer);

            //

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
