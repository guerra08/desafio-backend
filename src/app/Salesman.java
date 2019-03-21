package app;

public class Salesman{

    private String CNPJ;
    private String name;
    private double salary;

    public Salesman(String CNPJ, String name, double salary){
        this.CNPJ = CNPJ;
        this.name = name;
        this.salary = salary;
    }

    /**
     * @param cPF the CNPJ to set
     */
    public void setCPF(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    /**
     * @return the CNPJ
     */
    public String getCNPJ() {
        return CNPJ;
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

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }
    
}