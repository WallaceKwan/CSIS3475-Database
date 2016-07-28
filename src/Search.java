import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by wallacekwan on 2016-07-22.
 */
public class Search {

    Scanner stdin = new Scanner(System.in);

    String tableName, filePath;

    String line = "";
    String cvsSplitBy = ",";
    String[] lineArr = {};

    public boolean cont = true;

    String[] x = new String[5];
    String db[][] = new String[10][10];

    BufferedReader br;
    BufferedWriter bw;

    File file = null;

    //

    public void basicSearch() {

        System.out.print("Enter table to search: ");
        tableName = stdin.nextLine();
        filePath = tableName + "" + ".csv";
        file = new File(filePath);

        fillArr();

        //

        for (int t = 0; t < 5; t++) {

            for (int b = 0; b < 3; b++) {

            System.out.print("line has: " + db[t][b] + "  //  ");

            }

            System.out.println("");

        }

        Arrays.sort(db, new Comparator<String[]>() {
            public int compare(String[] int1, String[] int2) {
                String numOfKeys1 = int1[0];
                String numOfKeys2 = int2[0];
                int op = 0;

                try {
                    op = numOfKeys1.compareTo(numOfKeys2);
                } catch (NullPointerException e) {
                    System.out.println("error");
                }

                return op;
            }
        });
        System.out.println("================");

        for (int t = 0; t < 10; t++) {

            for (int b = 0; b < 3; b++) {

                System.out.print("line has: " + db[t][b] + "  //  ");

            }

            System.out.println("");

        }

        /*
        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {

                System.out.println(line);
                x = line.trim().split(",");
                List<String> sp = Arrays.asList(line.split(","));
                System.out.println("tt" + sp.get(1));
                //System.out.println("asd" + split[0]);
                System.out.println(Arrays.toString(x));

                //System.out.println("asd" + x[1]);
                System.out.println(x.length);


                for (int i = 0; i < x.length; i++) {

                    db[lines][0] = x[i];
                    //System.out.println("test" + db[lines][i]);

                    /*
                    for (int p = 0; p < x.length; p++) {
                        System.out.println("asd  " + x[p]);
                    }*/

                    //System.out.println("test print: " + x[i]);


                    //System.out.println(x[0]);
                    //System.out.println(x[1]);
                    //System.out.println(x[2]);

/*

                }

                lines++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int t = 0; t < 10; t++) {

            //for (int b = 0; b < 5; b++) {

                System.out.println(db[t][0]);

            //}

        }*/

        //System.out.println(x[1]);

        /*try {

            br = new BufferedReader(new FileReader(filePath));
            bw = new BufferedWriter(new FileWriter(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }



        //while (cont) {

            try {

                int lines = 0;


                br = new BufferedReader(new FileReader(filePath));

                //System.out.println("test");
                while ((line = br.readLine()) != null) {

                    System.out.println("test");

                    //line = br.readLine();

                    lineArr = line.split(cvsSplitBy);

                    // test

                    for (int a = 0; a < lineArr.length; a++) {
                        System.out.println(lineArr[a]);
                    }

                    //
                    lines++;

                }

            } catch (IOException e) {
                e.printStackTrace();
            }*/

        //}



    }

    public void FilterWhere() {

        System.out.print("Enter table to search: ");
        tableName = stdin.nextLine();
        filePath = tableName + "" + ".csv";
        file = new File(filePath);

        System.out.print("Enter field to search: ");
        String fieldName = stdin.nextLine();
        int fieldToSearch = 0;

        System.out.print("What to show in " + fieldName + ": ");
        String searchFor = stdin.nextLine();

        //System.out.println("ARRAY  " + db[0][0]);
        System.out.println("FIRST LINE SHOULD BE " + x[0] + " | " + x[1] + " | " + x[2]);

        for (int s = 0; s < x.length; s++) {

            if (x[s].contains(fieldName)) {
                fieldToSearch = s;
            }

        }

        //System.out.println("FIELD AT " + fieldToSearch);


        // Shows the line that was searched

        try {
            for (int t = 0; t < 10; t++) {

                if (db[t][fieldToSearch].contains(searchFor)) {

                    for (int v = 0; v < x.length; v++) {

                        System.out.print(db[t][v] + " | ");

                    }

                } else {
                    System.out.println("Field does not exist");
                    break;
                }


                System.out.println("");

            }
        } catch (NullPointerException e) {
            System.out.println("Array contains null");
        }

        /*for (int t = 0; t < 10; t++) {

            for (int b = 0; b < 3; b++) {

                System.out.print("filtered arr: " + db[t][b] + "  //  ");

            }

            System.out.println("");

        }*/


    }

    public void fillArr() {

        int lines = 0;


        //
        BufferedReader in = null;

        try {

            in = new BufferedReader(new FileReader(filePath));
            String read = null;

            int line = 0;

            read = in.readLine();
            x = read.split("\\s+");
            System.out.println("FIRST LINE " + x[1]);

            while ((read = in.readLine()) != null) {



                int stringLength = 0;
                String[] splited = read.split("\\s+");
                System.out.println(splited.length);

                for (String part : splited) {


                    System.out.println(part);
                    db[line][stringLength] = part;

                    System.out.println("string length " + stringLength);
                    stringLength++;

                    System.out.println("database current " + db[line][stringLength]);

                }

                line++;
                System.out.println("");

            }

        } catch (IOException e) {

            System.out.println("There was a problem: " + e);
            e.printStackTrace();

        } finally {

            try {
                in.close();
            } catch (Exception e) {
            }

        }
    }

}
