package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {

    public DataCounter processAllFolder(File folder) throws IOException {
        DataOperations dop = new DataOperations();
        File[] listOfFiles = folder.listFiles();
        int countSalesmen;
        int countCustomers;
        countCustomers = 0; countSalesmen = 0; 
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".dat")) {
                BufferedReader bfr = new BufferedReader(new FileReader(file));
                String reading = "";
                while((reading = bfr.readLine())!=null){
                    DataCounter c = dop.process(reading, countCustomers, countSalesmen);
                    countCustomers=+c.getCountCustomers();
                    countSalesmen=+c.getCountSalesmen();
                }
                bfr.close();
            } 
        }
        return (new DataCounter(countSalesmen, countCustomers));
    }    
}