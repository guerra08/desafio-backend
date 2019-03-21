package app;

public class Processing{

    public void countAmount(String data){

        String[] eachElement = data.split("(?=001ç)|(?=002ç)|(?=003ç)");

        int countCustomers = 0;
        int countSalesment = 0;

        for(int i = 0; i<eachElement.length; i++){
            if(eachElement[i].substring(0, 3).equals("001")){
                countSalesment++;
            }
            if(eachElement[i].substring(0, 3).equals("002")){
                countCustomers++;
            }
        }

        System.out.println(countSalesment+" Salesman.");
        System.out.println(countCustomers+" Customers.");

    }

}