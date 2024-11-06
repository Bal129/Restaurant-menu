package ooadfinal;

/**
 *
 * @author Iqbal
 */
public abstract class Menu {
    private String code = "000", name = "n/a";
    private float price = 0;
    protected Discount discount; // need to call setDiscount()
    
    // constructors
    
    public Menu() {}
    public Menu(String code, String name, float price) {
        setCode(code);
        setName(name);
        setPrice(price);
    }
    
    // methods
    
    @Override
    public String toString() {
        return "Code: " + code + "; Name: " + name + "; Price: " + price;
    }
    
    public void calculateNewPrice() {
        price = discount.calculatePrice(price);
    }
    
    // getters

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
    
    // setters

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}