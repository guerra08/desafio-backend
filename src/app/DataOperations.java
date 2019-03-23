package app;

import java.util.ArrayList; //Necessary imports

public class DataOperations{

    public DataReturn process(String data, int countCustomers, int countSalesmen){

        String[] eachElement = data.split("(?=001ç)|(?=002ç)|(?=003ç)"); //Regex with the 3 possible prefixes to be used as separators of the data
        ArrayList<Sale> sales = new ArrayList<>();

        for(int i = 0; i<eachElement.length; i++){
            if(eachElement[i].substring(0, 3).equals("001")){ //Prefix of salesman
                countSalesmen++;
            }
            if(eachElement[i].substring(0, 3).equals("002")){ //Prefix of customer
                countCustomers++;
            }
            if(eachElement[i].substring(0, 3).equals("003")){ //Prefix of sale
                String[] attributes = eachElement[i].split("ç");
                sales.add(new Sale(attributes[1],attributes[2],attributes[3]));
            }
        }
        return (new DataReturn(countSalesmen,countCustomers,sales));
    }
}