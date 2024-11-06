package ooadfinal;

/**
 *
 * @author Iqbal
 */
public class Food extends Menu {
    private String remarks = "n/a";
    
    // constructors
    
    public Food() {}
    public Food(String code, String name, float price) {
        super(code, name, price);
    }
    
    // methods
    
    @Override
    public String toString() {
        return "Code: " + super.getCode() + 
               "; Name: " + super.getName() + 
               "; Price: " + super.getPrice() +
               "; Remarks: " + getRemarks();
    }
    
    // getters

    public String getRemarks() {
        return remarks;
    }
    
    // setters

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}