package app;

import java.util.ArrayList;

public class DataReturn{ //Class to store values of the counters

    private int countCustomers;
    private int countSalesmen;
    private ArrayList<Sale> sales = new ArrayList<>();

    public DataReturn(int countSalesmen, int countCustomers, ArrayList<Sale> sales){
        setCountSalesmen(countSalesmen);
        setCountCustomers(countCustomers);
        setSale(sales);
    }

    /**
     * @param countCustomers the countCustomers to set
     */
    public void setCountCustomers(int countCustomers) {
        this.countCustomers = countCustomers;
    }

    /**
     * @return the countCustomers
     */
    public int getCountCustomers() {
        return countCustomers;
    }

    /**
     * @param countSalesmen the countSalesmen to set
     */
    public void setCountSalesmen(int countSalesmen) {
        this.countSalesmen = countSalesmen;
    }

    /**
     * @return the countSalesmen
     */
    public int getCountSalesmen() {
        return countSalesmen;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    /**
     * @return the sale
     */
    public ArrayList<Sale> getSales() {
        return sales;
    }

}