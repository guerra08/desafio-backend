package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import app.Processing.Counter;

public class App {
    public static void main(String[] args) throws Exception {

        Processing p = new Processing();

        String home = System.getProperty("user.home");
        File folder = new File(home+"/data/in");
        File[] listOfFiles = folder.listFiles();

        int countSalesmen;
        int countCustomers;
        countCustomers = 0; countSalesmen = 0; 

        long startTime = System.nanoTime();

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".dat")) {
                BufferedReader bfr = new BufferedReader(new FileReader(file));
                String reading = "";
                while((reading = bfr.readLine())!=null){
                    Counter c = p.process(reading, countCustomers, countSalesmen);
                    countCustomers=+c.getCountCustomers();
                    countSalesmen=+c.getCountSalesmen();
                }
                bfr.close();
            } 
        }

        System.out.println(countCustomers + " Customers. " + countSalesmen + " Salesmen.");

        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}