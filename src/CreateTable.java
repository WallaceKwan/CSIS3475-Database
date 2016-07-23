import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by wallacekwan on 2016-06-26.
 */

public class CreateTable {

    CSV csv = new CSV();

    File file = null;

    Scanner stdin = new Scanner(System.in);

    String tableName, filePath, fieldName, dataType, name;
    String[] fn;

    Boolean addField = true;

    HashMap<String, String> fieldNames = new HashMap<>();



    public CreateTable() {

        System.out.println("Table creation selected\n");

        // Declares table name and file path for table


        System.out.print("Enter table name: ");

        tableName = stdin.nextLine();

        filePath = tableName + "" + ".csv";

        file = new File(filePath);

        // Checks if table exists

        if (!csv.checkForFile(tableName)) {

            System.out.println("Creating table with name: " + tableName + "\n");

            // Field naming

            System.out.println("Field syntax is 'data type' <space> 'field name'");
            System.out.println("Data types tested/supported: String, int");
            System.out.println("Blank entry to quit\n");

            while (addField) {

                System.out.print("Data type <space> name: ");

                fieldName = stdin.nextLine();

                // If user enters nothing then end adding fields

                if (!fieldName.equals("")) {

                    try {
                        fn = fieldName.split(" ");


                        // '0' is the data type, '1' is the name for the field
                        dataType = fn[0];
                        name = fn[1];

                        fieldNames.put(fn[1], fn[0]);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("\nMust have declare a data type and name\n");
                    }

                } else {

                    addField = false;

                }

            }

            // Actually creating the file

            csv.createNewFile(filePath, tableName, fieldNames);

        }

        // Shows fields

        try {

            System.out.println("\nThere are currently " + (csv.addRecords(filePath).length - 1)
                    + " fields in " + file.getName() + "\n");

        } catch (NullPointerException e) {

            System.out.println("There are no fields in " + file.getName() + "\n");

        }

    }


}

//filePath = "c:\\" + "" + tableName + "" + ".csv";

//System.out.println(filePath);
//csv.readFromFile(filePath);

//ArrayList<ArrayList<String>> tables = new ArrayList<>();

/*for (Map.Entry<String, String> entry : fieldNames.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }*/
//System.out.println("");
