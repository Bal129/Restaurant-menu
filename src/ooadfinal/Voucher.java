package ooadfinal;

/**
 *
 * @author Iqbal
 */
public class Voucher implements Discount {
    private String code = "n/a";
    private float value = 1; // value of % cut
    private boolean used = false;

    // constructors
    
    public Voucher(String code, float value) {
        setCode(code);
        setValue(value);
    }
    
    // implemented methods
    
    @Override
    public float calculatePrice(float price) {
        return price*value;
    }

    @Override
    public void switchUsability() {
        used = !used;
    }
    
    @Override
    public String toString() {
        return "Code: "+code+"; Value: "+value;
    }
    
    // getters
    
    public String getCode() {
        return code;
    }

    public float getValue() {
        return value;
    }

    // setters
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setValue(float value) {
        this.value = value;
    }
}
