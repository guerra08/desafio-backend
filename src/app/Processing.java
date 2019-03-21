package app;

public class Processing{

    public Counter process(String data, int countCustomers, int countSalesmen){

        String[] eachElement = data.split("(?=001ç)|(?=002ç)|(?=003ç)");

        for(int i = 0; i<eachElement.length; i++){
            if(eachElement[i].substring(0, 3).equals("001")){
                countSalesmen++;
            }
            if(eachElement[i].substring(0, 3).equals("002")){
                countCustomers++;
            }
        }
        return (new Counter(countSalesmen, countCustomers));
    }

    public class Counter{

        private int countCustomers;
        private int countSalesmen;

        public Counter(int countSalesmen, int countCustomers){
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

}