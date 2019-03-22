package app;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {

        FileOperations fop = new FileOperations();
        Scanner sc = new Scanner(System.in);

        String home = System.getProperty("user.home");
        File folder = new File(home+"/data/in");
        String folderToString = folder.toString();

        System.out.println("-------------- Sistema de gerenciamento de dados --------------");
        System.out.println(" ");
        System.out.println("Deseja processar os arquivos atuais do diretório "+folder.getAbsolutePath()+"? (S | N)");
        String input = sc.nextLine();

        if(input.equals("S")||input.equals("s")){
            DataCounter doc = fop.processAllFolder(folder);
            System.out.println(doc.getCountSalesmen() + " - " + doc.getCountCustomers());
        }
        else if(input.equals("N")||input.equals("n")){
            FileMonitor fm = new FileMonitor();
            fm.monitorFolder(folderToString);
        }
    }
}