package ooadfinal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Iqbal
 */
public class GuiMenuPopup extends JFrame {
    private static final int width = 300;
    private static final int height = 200;
    public static final String ADD_TO_CART = "Add";
    public static final String ADD_TO_CART_HOT = "Add(Hot)";
    public static final String ADD_TO_CART_COLD = "Add(Cold)";
    public static final int FOOD = 1;
    public static final int DRINK = 2;
    JPanel panelMenu;
    JLabel labelMenuPicture;
    JLabel labelMenuName;
    JButton buttonAdd;
    JButton buttonAddHot;
    JButton buttonAddCold;
    
    // constructors
    
    public GuiMenuPopup(String menuName, ImageIcon menuImage, int type) {
        init(menuName, menuImage, type);
    }
    
    // methods
    
    private void init(String menuName, ImageIcon menuImage, int type) {
        GridBagConstraints g = new GridBagConstraints();
        panelMenu = new JPanel(new GridBagLayout());
        labelMenuPicture = new JLabel(menuImage);
        labelMenuName = new JLabel(menuName);
        buttonAdd = new JButton(ADD_TO_CART);
        buttonAddHot = new JButton(ADD_TO_CART_HOT);
        buttonAddCold = new JButton(ADD_TO_CART_COLD);
        buttonAdd.setPreferredSize(new Dimension(width,30));
        buttonAddHot.setPreferredSize(new Dimension(width/2,30));
        buttonAddCold.setPreferredSize(new Dimension(width/2,30));
        buttonAdd.setMinimumSize(new Dimension(width,30));
        buttonAddHot.setMinimumSize(new Dimension(width/2,30));
        buttonAddCold.setMinimumSize(new Dimension(width/2,30));
        
        int column = 0;
        int row = 0;
        g.gridx = column;
        g.gridy = row++;
        g.gridwidth = 2;
        panelMenu.add(labelMenuPicture, g);
        g.gridy = row++;
        panelMenu.add(labelMenuName, g);
        
        g.gridwidth = 1;
        switch(type) {
            case FOOD:
                g.gridy = row++;
                panelMenu.add(buttonAdd, g);
                break;
            case DRINK:
                g.gridy = ++row;
                panelMenu.add(buttonAddHot, g);
                g.gridx = ++column;
                panelMenu.add(buttonAddCold, g);
                break;
        }
        
        this.add(panelMenu, BorderLayout.SOUTH);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    // getters

    public JPanel getPanelMenu() {
        return panelMenu;
    }

    public JLabel getLabelMenuPicture() {
        return labelMenuPicture;
    }

    public JLabel getLabelMenuName() {
        return labelMenuName;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }
}

// remove later
//
//class TestPopup {
//    public static void main(String args[]) {
//        GuiMenuPopup g = new GuiMenuPopup("Taco", null, GuiMenuPopup.FOOD);
//    }
//}