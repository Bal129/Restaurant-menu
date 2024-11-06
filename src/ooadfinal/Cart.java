package ooadfinal;

/**
 *
 * @author Iqbal
 */
public class Cart {
    private String name;
    private float price;
    private int quantity;
    
    // constructors
    
    public Cart(String name, float price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }
    
    // methods
    
    public float calculateTotal() {
        return price*quantity;
    }
    
    // getters
    
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}