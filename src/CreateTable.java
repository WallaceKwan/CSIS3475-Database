import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wallacekwan on 2016-06-26.
 */

public class CreateTable {

    CSV csv = new CSV();

    Scanner stdin = new Scanner(System.in);

    String tableName, fieldName, dataType, name;
    String[] fn;

    Boolean addField = true;

    //ArrayList<ArrayList<String>> tables = new ArrayList<>();
    ArrayList<ArrayList<String>> tables = new ArrayList<>();

    HashMap<String, String> fieldNames = new HashMap<>();

    String filePath = "";

    public CreateTable() {

        System.out.print("Enter table name: ");
        tableName = stdin.nextLine();

        filePath = "c:\\" + "" + tableName + "" + ".csv";

        if (csv.checkForFile(tableName)) {

            System.out.println("Test file already exists");
            System.out.println(filePath);

            csv.readFromFile(filePath);

        }

        else {

            this.tableName = tableName;
            System.out.println("Creating table: " + tableName);

            //tables.add(new ArrayList<String>(tableName));

            System.out.println(tables);

            // Field naming
            System.out.println("Field syntax is 'data type' followed by 'field name': ");

            while (addField) {

                System.out.print("Data type <space> name: ");

                fieldName = stdin.nextLine();

                if (!fieldName.equals("")) {


                    fn = fieldName.split(" ");

                    // '0' is the data type, '1' is the name for the field
                    dataType = fn[0];
                    name = fn[1];

                /*for (int x = 0; x < fn.length; x++) {
                    System.out.println(fn[x]);
                }*/

                    fieldNames.put(fn[1], fn[0]);

                } else {

                    addField = false;

                }

            }

            csv.createNewFile(tableName, fieldNames);

        }

        System.out.println(fieldNames.size());
        for (Map.Entry<String, String> entry : fieldNames.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

    }

}
