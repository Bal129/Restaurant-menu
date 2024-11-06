package ooadfinal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Iqbal
 */
public class GuiMenu extends JPanel {
    private static final String HEADER = "Menu";
    private static final String FOOD = "Food";
    private static final String DRINK = "Drink";
    private JPanel headerPanel;
    private JPanel contentPanel;
    private JScrollPane contentPanelScroll;
    private static int currentX = 0;
    private static int currentY = 0;
    private GridBagConstraints constraints = new GridBagConstraints();
    private GuiCart guiCart;
    
    // components for top panel
    
    private JLabel headerLabel;
    
    // components for contents
    
    private JButton labelFood;
    private JButton labelDrink;
    private ArrayList<JButton> foodButtons; // to create list of foods in menu
    private ArrayList<JButton> drinkButtons;
    private ArrayList<Food> foods;
    private ArrayList<Drink> drinks;
    private ArrayList<Cart> carts;
    private static String cartName = null;
    private static float cartPrice = 0;
    
    public GuiMenu(GuiCart guiCart, ArrayList<Food> foods, ArrayList<Drink> drinks) {
        this.guiCart = guiCart;
        setFoods(foods);
        setDrinks(drinks);
        this.setLayout(new BorderLayout(10, 10));
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanelScroll = new JScrollPane(
            contentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        contentPanelScroll.setBorder(null);
        this.add(contentPanelScroll, BorderLayout.CENTER);
        initTop();
        initFood();
        initDrink();
    }

    private void initTop() {
        headerPanel = new JPanel();
        headerLabel = new JLabel(HEADER);
        headerPanel.add(headerLabel);
        this.add(headerPanel, BorderLayout.NORTH);
    }
     
    private void initFood() {
        foodButtons = new ArrayList<>();
        labelFood = new JButton(FOOD);
        constraints.gridwidth = 4;
        constraints.gridx = currentX = 0;
        constraints.gridy = currentY = 0;
        constraints.insets = new Insets(20, 10, 20, 10);
        contentPanel.add(labelFood, constraints);
        
        constraints.gridwidth = 1;
        constraints.gridy = ++currentY;
        constraints.insets = new Insets(10, 5, 10, 5);
        int index = 0;
        for(Food food: foods) { 
            constraints.gridx = currentX++;
            constraints.gridy = currentY;
            JButton button = new JButton(food.getName()+":$"+food.getPrice()); // <- create buttons
            button.setActionCommand(food.getName());
            button.addActionListener(new AddToCart());
            foodButtons.add(button);
            foodButtons.get(index).setPreferredSize(new Dimension(175,150));
            contentPanel.add(foodButtons.get(index), constraints);
            if (currentX%4 == 0) {
                currentX = 0;
                currentY++;
            }
            index++;
        }
    }
    
    private void initDrink() {
        drinkButtons = new ArrayList<>();
        labelDrink = new JButton(DRINK);
        constraints.gridwidth = 4;
        constraints.gridx = currentX = 0;
        constraints.gridy = ++currentY;
        constraints.insets = new Insets(20, 10, 20, 10);
        contentPanel.add(labelDrink, constraints);
        
        constraints.gridwidth = 1;
        constraints.gridy = ++currentY;
        constraints.insets = new Insets(10, 5, 10, 5);
        int index = 0;
        for(Drink drink: drinks) { // change to normal for loop if failed
        //for(int i=0; i<num; i++) {
            constraints.gridx = currentX++;
            constraints.gridy = currentY;
            JButton button = new JButton(drink.getName()+":$"+drink.getPrice());
            button.setActionCommand(drink.getName());
            button.addActionListener(new AddToCart());
            drinkButtons.add(button);
            drinkButtons.get(index).setPreferredSize(new Dimension(175,150));
            contentPanel.add(drinkButtons.get(index), constraints);
            if (currentX%4 == 0) {
                currentX = 0;
                currentY++;
            }
            index++;
        }
    }
    
    // nested class
    
    class AddToCart implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(Food food: foods) {
                if(e.getActionCommand().equals(food.getName())) {
                    guiCart.addCart(new Cart(food.getName(), food.getPrice()));
                    return;
                }
            }
            for(Drink drink: drinks) {
                if(e.getActionCommand().equals(drink.getName())) {
                    guiCart.addCart(new Cart(drink.getName(), drink.getPrice()));
                    return;
                }
            }
        }
    }
    
    // getters

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public JLabel getHeaderLabel() {
        return headerLabel;
    }

    public JScrollPane getContentPanelScroll() {
        return contentPanelScroll;
    }

    public JButton getLabelFood() {
        return labelFood;
    }

    public JButton getLabelDrink() {
        return labelDrink;
    }

    public ArrayList<JButton> getFoodButtons() {
        return foodButtons;
    }

    public ArrayList<JButton> getDrinkButtons() {
        return drinkButtons;
    }
    
    // setters

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }
}
