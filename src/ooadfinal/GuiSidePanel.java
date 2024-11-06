package ooadfinal;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Iqbal
 */
public class GuiSidePanel extends JPanel {
    private static int width;
    private static int height;
    public static final String PROFILE = "PROFILE";
    public static final String MENU = "MENU";
    public static final String CART = "CART";
    private JButton btnProfile = new JButton(PROFILE);
    private JButton btnMenu = new JButton(MENU);
    private JButton btnCart = new JButton(CART);
    
    // constructors
    
    public GuiSidePanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        initPanel();
    }
    
    // methods
    
    private void initPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton[] buttons = {btnProfile, btnMenu, btnCart};
        for(JButton button: buttons) {
            button.setPreferredSize(new Dimension(width,100));
            button.setMaximumSize(new Dimension(width,100));
            button.setAlignmentX(CENTER_ALIGNMENT);
            this.add(button);
        }
    }
    
    // getters

    public JButton getBtnProfile() {
        return btnProfile;
    }

    public JButton getBtnMenu() {
        return btnMenu;
    }

    public JButton getBtnCart() {
        return btnCart;
    }

    // setters
    
    public void setBtnProfile(JButton btnProfile) {
        this.btnProfile = btnProfile;
    }

    public void setBtnMenu(JButton btnMenu) {
        this.btnMenu = btnMenu;
    }

    public void setBtnCart(JButton btnCart) {
        this.btnCart = btnCart;
    }
}
