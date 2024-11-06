package ooadfinal;

/**
 *
 * @author Iqbal
 */
public class Drink extends Menu {
    private boolean isHot = false;
    
    // constructors
    
    public Drink(){}
    public Drink(String code, String name, float price, boolean isHot) {
        super(code, name, price);
        this.isHot = isHot;
    }
    
    // methods
    
    @Override
    public String toString() {
        return "Code: " + super.getCode() + 
               "; Name: " + super.getName() + 
               "; Price: " + super.getPrice() +
               "; Hot: " + getIsHot();
    }
    
    // getters
    
    public boolean getIsHot() {
        return isHot;
    }
    
    // setters
    
    public void setIsHot() {
        this.isHot = isHot;
    }
}