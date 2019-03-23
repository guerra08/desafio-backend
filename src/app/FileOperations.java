package app;

//Necessary imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Stream;

public class FileOperations {

    public void processAllFolder(File folder) throws IOException {
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

        DataReturn dataRet = new DataReturn(countSalesmen,countCustomers,totalSales);
        Stream<Sale> streamTotalPrice = dataRet.getSales().stream(); //Creating stream from ArrayList in order to execute operations more easily
        Sale s = streamTotalPrice.min(Comparator.comparing(Sale::getTotalPrice)).get(); //Sale with the highest value in price
        printToOut(dataRet.getCountSalesmen(), dataRet.getCountCustomers(), s.getId());
        
        System.out.println("Processamento finalizado!");
    }    

    public void printToOut(int countSalesmen, int countCustomers, String saleId) throws IOException {
        String home = System.getProperty("user.home");
        File file = new File(home+"/data/out/data.out.dat");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.toString(),true));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
        writer.write("Vendedores: "+countSalesmen + "; Clientes: " + countCustomers + "; Venda com maior valor: " + saleId + "; Dados gravados em: " + dateFormat.format(date));
        writer.newLine();
        writer.close();
    }
}