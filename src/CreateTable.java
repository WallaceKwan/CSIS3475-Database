import java.util.ArrayList;

/**
 * Created by wallacekwan on 2016-06-26.
 */

public class CreateTable {

    ArrayList<String> tables = new ArrayList<>();

    public CreateTable(String tableName) {

        System.out.println("Creating table: " + tableName);
        tables.add(tableName);

        System.out.println(tables);

    }

}
