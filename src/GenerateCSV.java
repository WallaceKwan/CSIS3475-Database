import java.io.*;

/**
 * Created by wallacekwan on 2016-06-29.
 */

public class GenerateCSV {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header (Enter own values)
    private static final String FILE_HEADER = "id,firstName,lastName,gender,age";


    public GenerateCSV(String tableName) {

        if (new File("c:\\" + "" + tableName + "" + ".csv").exists()) {

            System.out.println("Test file already exists");

            //read from file

        }

        else {

            try {

                FileWriter writer = new FileWriter("c:\\" + "" + tableName + "" + ".csv");

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

}
