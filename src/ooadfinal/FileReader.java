package ooadfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Iqbal
 */
public class FileReader {
    public static final String TXT_DIR = "txt";
    public static final int FOOD = 1;
    public static final int DRINK = 2;
    public static final int VOUCHER = 3;
    public static final int MENU_CODE = 0;
    public static final int MENU_NAME = 1;
    public static final int MENU_PRICE = 2;
    public static final int DRINK_IS_HOT = 3;
    public static final int VOUCHER_CODE = 0;
    public static final int VOUCHER_VALUE = 1;
    private ArrayList<String> dataArray;
    private ArrayList<Food> foods;
    private ArrayList<Drink> drinks;
    private ArrayList<Voucher> vouchers;
    private Scanner scanner;
    
    // methods
    
    public void extractMenu(File file, int type) throws FileNotFoundException {
        dataArray = new ArrayList<>();
        scanner = new Scanner(file);
        foods = new ArrayList<>();
        drinks = new ArrayList<>();
        while(scanner.hasNextLine()) { // read rows from txt file
            dataArray.add(scanner.nextLine());
        }
        String[] menuData; // to store columns of each rows
        for(String data: dataArray) {
            menuData = data.split(",");
            switch(type) {
                case FOOD:
                    foods.add(new Food(
                        menuData[MENU_CODE],
                        menuData[MENU_NAME], 
                        Float.parseFloat(menuData[MENU_PRICE])
                    ));
                    break;
                case DRINK:
                    drinks.add(new Drink(
                        menuData[MENU_CODE],
                        menuData[MENU_NAME], 
                        Float.parseFloat(menuData[MENU_PRICE]),
                        Boolean.parseBoolean(menuData[DRINK_IS_HOT])
                    ));
                    break;
            }
        }
        scanner.close();
    }
    
    public void extractDiscount(File file, int type) throws FileNotFoundException {
        dataArray = new ArrayList<>();
        vouchers = new ArrayList<>();
        scanner = new Scanner(file);
        while(scanner.hasNextLine()) { // read rows from txt file
            dataArray.add(scanner.nextLine());
        }
        String[] voucherData;
        for(String data: dataArray) {
            voucherData = data.split(",");
            switch(type) {
                case VOUCHER:
                    vouchers.add(new Voucher(
                        voucherData[VOUCHER_CODE],
                        Float.parseFloat(voucherData[VOUCHER_VALUE])
                    ));
                    break;
            }
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