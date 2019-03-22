package app;
public class DataCounter{ //Class to store values of the counters

    private int countCustomers;
    private int countSalesmen;

    public DataCounter(int countSalesmen, int countCustomers){
        setCountSalesmen(countSalesmen);
        setCountCustomers(countCustomers);
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
}