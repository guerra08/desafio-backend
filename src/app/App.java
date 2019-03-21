package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {

        Processing p = new Processing();

        String home = System.getProperty("user.home");
        File folder = new File(home+"/data/in");
        File[] listOfFiles = folder.listFiles();

        long startTime = System.nanoTime();

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".dat")) {
                BufferedReader bfr = new BufferedReader(new FileReader(file));
                String reading = "";
                while((reading = bfr.readLine())!=null){
                    p.countAmount(reading);
                }
                bfr.close();
            } 
        }

        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}