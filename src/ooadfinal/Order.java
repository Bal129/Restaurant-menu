package ooadfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Iqbal
 */
public class Order {
    public static final String TXT_DIR = "txt\\";
    public static final String FOOD_FILE = "Food.txt";
    public static final String DRINK_FILE = "Drink.txt";
    public static final String VOUCHER_FILE = "Voucher.txt";
    private FileReader fileReader;
    private ArrayList<Food> foods;
    private ArrayList<Drink> drinks;
    private ArrayList<Voucher> vouchers;
    
    // constructors
    
    public Order() {
        fileReader = new FileReader();
        extractData();
        // assignDiscount();
    }
    
    // methods
    
    public void extractData() {
        try {
            fileReader.extractMenu(new File(TXT_DIR+FOOD_FILE), FileReader.FOOD);
            foods = fileReader.getFoods();
            fileReader.extractMenu(new File(TXT_DIR+DRINK_FILE), FileReader.DRINK);
            drinks = fileReader.getDrinks();
            fileReader.extractDiscount(new File(TXT_DIR+VOUCHER_FILE), FileReader.VOUCHER);
            vouchers = fileReader.getVouchers();
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // getters

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Voucher> getVouchers() {
        return vouchers;
    }
}

// remove later
//
//class TestingOrder {
//    public static void main(String[] args) {
//        Order o = new Order();
//        System.out.println(o.getFoods());
//        System.out.println(o.getDrinks());
//    }
//}




