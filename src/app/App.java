package app;


import java.util.Scanner;
import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {

        FileOperations fop = new FileOperations();
        FileMonitor fm = new FileMonitor();
        Scanner sc = new Scanner(System.in);
        
        String home = System.getProperty("user.home");
        File folder = new File(home+"/data/in");
        String folderToString = folder.toString();

        System.out.println("-------------- Sistema de gerenciamento de dados --------------");
        System.out.println(" ");
        System.out.println("Deseja processar os arquivos atuais do diretório "+folder.getAbsolutePath()+"? (S | N)");
        String input = sc.nextLine();

        if(input.equals("S")||input.equals("s")){ //If you want to perform a check with the existing files in the HOMEPATH
            fop.processAllFolder(folder);
            fm.monitorFolder(folderToString);
        }
        else if(input.equals("N")||input.equals("n")){ //If you do not want to perform a check with the existing files in the HOMEPATH
            fm.monitorFolder(folderToString);
        }
        sc.close();
    }
}