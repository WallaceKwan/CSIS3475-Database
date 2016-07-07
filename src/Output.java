import java.util.*;

/**
 * Created by wallacekwan on 2016-06-26.
 */

public class Output {

    public Output() {

        CSV csv = new CSV();

        Scanner stdin = new Scanner(System.in);
        int option;
        String tableName = "test";

        boolean run = true;

        ArrayList<String> tables = new ArrayList<>();
        ArrayList<HashMap<String, String>> fields = new ArrayList<>();

        ///

        System.out.println("CSIS 3475 - Database project\n");


        while(run) {

            try {

                System.out.println("Following options available: \n" +
                        "1) Create table\n" +
                        "2) Create field\n" +
                        "5) Exit\n");

                System.out.print("Enter corresponding number: ");

                option = stdin.nextInt();
                System.out.println("");
                stdin.nextLine();
                switch (option) {

                    case 1:

                        System.out.print("Enter table name: ");
                        tableName = stdin.nextLine();
                        new CreateTable(tableName);
                        break;

                    case 2:

                        //System.out.print("Enter field names: ");

                    case 5:
                        System.exit(0);
                        break;

                    default:
                        break;

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input");
                stdin.nextLine();

            }

            // TEMP Remove when looping is needed
            System.out.println("\n*Temp exit*\n");
            System.exit(0);

        }

    }



}
