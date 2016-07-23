import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by wallacekwan on 2016-07-20.
 */

public class Fields {

    CSV csv = new CSV();

    Scanner stdin = new Scanner(System.in);

    String tableName, filePath, dataInput;

    String[] existingFields;
    String[] recordInput = {};

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header (Enter own values)
    private String FILE_HEADER = "";

    public void checkForTable() {

        System.out.print("Table name: ");
        tableName = stdin.nextLine();
        filePath = tableName + "" + ".csv";
        File file = new File(filePath);

        if (csv.checkForFile(tableName)) {

            //csv.addFieldsToFile(filePath);
            try {

                existingFields = csv.addRecords(filePath);

                addToTable();

            } catch (NullPointerException e) {

                System.out.println("The table " + file.getName() + " is empty\n");

            }


        }

        else {

            System.out.println("This table does not exist\n");

        }

    }

    public void addToTable() {

        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(filePath, true));



            System.out.println("There are " + (existingFields.length - 1);

            bw.append(NEW_LINE_SEPARATOR);

            for (int x = 0; x < existingFields.length - 1; x++) {


                System.out.print("Field - " + existingFields[x] + ": ");
                dataInput = stdin.nextLine();

                bw.append(dataInput);
                bw.append(COMMA_DELIMITER);

            }

            bw.append(NEW_LINE_SEPARATOR);

            // STOP FORGETTING
            bw.flush();
            bw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");

    }

}
