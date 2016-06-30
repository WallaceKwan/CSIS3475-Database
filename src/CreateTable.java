import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wallacekwan on 2016-06-26.
 */

public class CreateTable {

    Scanner stdin = new Scanner(System.in);

    String tableName, fieldName;
    ArrayList<String> fieldNames = new ArrayList<>();

    Boolean addField = true;

    //ArrayList<ArrayList<String>> tables = new ArrayList<>();
    ArrayList<ArrayList<String>> tables = new ArrayList<>();

    public CreateTable(String tableName) {

        System.out.println("Creating table: " + tableName);

        //tables.add(new ArrayList<String>(tableName));

        System.out.println(tables);

        // Field naming
        System.out.println("Field syntax is 'data type' followed by 'field name': ");

        while (addField) {

            System.out.print("Data type <space> name: ");
            fieldName = stdin.nextLine();

            if (!fieldName.equals("")) {

                fieldNames.add(fieldName);

            }
            else {

                addField = false;

            }

        }

        System.out.println("Field names are: " + fieldNames);



    }

}
