package app;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;

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
            DataReturn doc = fop.processAllFolder(folder);
            Stream<Sale> streamSales = doc.getSales().stream();
            Sale s = streamSales.min(Comparator.comparing(Sale::getTotalPrice)).get();
            System.out.println(s.getId());
        }
        else if(input.equals("N")||input.equals("n")){
            FileMonitor fm = new FileMonitor();
            fm.monitorFolder(folderToString);
        }
    }
}