package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperations {

    public DataReturn processAllFolder(File folder) throws IOException {
        DataOperations dop = new DataOperations();
        File[] listOfFiles = folder.listFiles();
        ArrayList<Sale> totalSales = new ArrayList<>();
        int countSalesmen;
        int countCustomers;
        countCustomers = 0; countSalesmen = 0; 
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".dat")) {
                BufferedReader bfr = new BufferedReader(new FileReader(file));
                String reading = "";
                while((reading = bfr.readLine())!=null){
                    DataReturn c = dop.process(reading, countCustomers, countSalesmen);
                    countCustomers=+c.getCountCustomers();
                    countSalesmen=+c.getCountSalesmen();
                    totalSales.addAll(c.getSales());
                }
                bfr.close();
            } 
        }
        return (new DataReturn(countSalesmen, countCustomers,totalSales));
    }    
}