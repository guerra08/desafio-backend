package app;

public class Sale{

    private String id;
    private String products;
    private String salesman;
    private double totalPrice; 

    public Sale(String id, String products, String salesman){
        this.id = id;
        this.products = products;
        this.salesman = salesman;
        this.totalPrice = 0.0;
   
        //When recieving the string with the products, split each product with ',' and remove unnecessary chars.
        String[] eachProduct = this.products.split(",");
        for (int i = 0; i < eachProduct.length; i++) {
            eachProduct[i] = eachProduct[i].replace("[","").replace("]","");
        }
        //Calculate the total price of the sale by making multiplying the product price with the amount bought.
        for (int j = 0; j < eachProduct.length; j++) {
            String[] priceAmount = eachProduct[j].split("-");
            this.totalPrice = this.totalPrice + (Double.parseDouble(priceAmount[1]) * Double.parseDouble(priceAmount[2])); //Example: 1-10-100. The product id is 1, the amount is 10 and the price is 100.
        }
        eachProduct = null;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {this.id = id;}

    /**
     * @return the id
     */
    public String getId() {return id;}

    /**
     * @param products the products to set
     */
    public void setProducts(String products) {this.products = products;}

    /**
     * @return the products
     */
    public String getProducts() {return products;}
    
    /**
     * @param salesman the salesman to set
     */
    public void setSalesman(String salesman) {this.salesman = salesman;}

    /**
     * @return the salesman
     */
    public String getSalesman() {return salesman;}

    /**
     * @return the totalPrice
     */
    public Double getTotalPrice() {return totalPrice;}
    
}