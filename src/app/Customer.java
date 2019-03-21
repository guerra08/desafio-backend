package app;
public class Customer{

    private String CPF;
    private String name;
    private String businessArea;

    public Customer(String CPF, String name, String businessArea){
        this.CPF = CPF;
        this.name = name;
        this.businessArea = businessArea;
    }

    /**
     * @param businessArea the businessArea to set
     */
    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    /**
     * @return the businessArea
     */
    public String getBusinessArea() {
        return businessArea;
    }

    /**
     * @param CPF the cPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}