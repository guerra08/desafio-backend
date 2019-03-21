package app;

public class Processing{

    public void process(String data, int countCustomers, int countSalesmen){

        String[] eachElement = data.split("(?=001ç)|(?=002ç)|(?=003ç)");

        for(int i = 0; i<eachElement.length; i++){
            if(eachElement[i].substring(0, 3).equals("001")){
                countSalesmen++;
            }
            if(eachElement[i].substring(0, 3).equals("002")){
                countCustomers++;
            }
        }

    }

}