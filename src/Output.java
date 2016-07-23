import java.util.*;

/**
 * Created by wallacekwan on 2016-06-26.
 *
 * GITHUB https://github.com/WallaceKwan/CSIS3475-Database
 *
 */

public class Output {

    public Output() {

        Fields fields = new Fields();

        Scanner stdin = new Scanner(System.in);

        boolean run = true;

        int option;

        //Remove
        //ArrayList<String> tables = new ArrayList<>();
        //ArrayList<HashMap<String, String>> fi = new ArrayList<>();

        ////

        System.out.println("CSIS 3475 - Database project\n");

        while(run) {

            try {

                System.out.println("Following options available: \n" +
                        "1) Create table\n" +
                        "2) Add records\n" +
                        "3) \n" +
                        "5) Exit\n");

                System.out.print("Enter corresponding number: ");

                option = stdin.nextInt();

                System.out.println("");
                stdin.nextLine();

                switch (option) {

                    // Create table
                    case 1:

                        new CreateTable();

                        break;

                    // Add fields
                    case 2:

                        fields.checkForTable();

                        break;

                    // Add records
                    case 3:

                        //fields.checkForTable();

                        break;

                    // Terminate program
                    case 5:

                        System.out.println("Program terminated");
                        run = false;
                        System.exit(0);

                        break;

                    default:

                        break;

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input\n");
                stdin.nextLine();

            }

            // TEMP Remove when looping is needed
            //System.out.println("\n*Temp exit*\n");
            //System.exit(0);

        }

    }


}
