package ooadfinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Iqbal
 */
public class GuiMainFrame extends JFrame implements ActionListener {
    private GuiBottomPanel guiBottomPanel;
    private GuiSidePanel guiSidePanel;
    private GuiProfile guiProfile;
    private GuiMenu guiMenu;
    private GuiCart guiCart;
    private JPanel bottomPanel;
    private JPanel sidePanel;
    private JPanel topPanel;
    private JPanel centerPanel;
    private Order order;
    private static final int WIDTH = 960;
    private static final int HEIGHT = 720;
    
    public GuiMainFrame() {
        super("OOAD Final Assignment");
        order = new Order();
        initFrame();
    }
    
    private void initTopPanel() {
        JLabel header = new JLabel("RESTAURANT");
        header.setFont(GuiTheme.fontHeader);
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT/10));
        topPanel.setBackground(GuiTheme.backgroundColor1); // bg color
        topPanel.add(header);
    }
    
    private void initSidePanel() {
        guiSidePanel = new GuiSidePanel(WIDTH/6, HEIGHT/2);
        JButton buttons[] = { // group button into an array to assign theme once only
            guiSidePanel.getBtnProfile(),
            guiSidePanel.getBtnCart(),
            guiSidePanel.getBtnMenu()
        };
        for(JButton button: buttons) { // set theme to buttons
            button.setFont(GuiTheme.fontButton1);
            button.setForeground(GuiTheme.buttonTextColor);
            button.setBackground(GuiTheme.buttonBackColor);
            button.addActionListener(this);
        }
        guiSidePanel.setBackground(GuiTheme.backgroundColor1); // bg color
        sidePanel = new JPanel(new BorderLayout());
        sidePanel.add(guiSidePanel);//, BorderLayout.SOUTH);
    }
    
    private void initBottomPanel() {
        guiBottomPanel = new GuiBottomPanel(WIDTH, HEIGHT/25);
        guiBottomPanel.setBackground(GuiTheme.backgroundColor1); // bg color
        JButton[] buttons = {
            guiBottomPanel.getBtnFindUs(),
            guiBottomPanel.getBtnCustomerService(),
            guiBottomPanel.getBtnFaq(),
            guiBottomPanel.getBtnHalal(),
            guiBottomPanel.getBtnAboutUs()
        };
        for(JButton button: buttons) { // set theme to buttons
            button.setFont(GuiTheme.fontButton2);
            button.setForeground(GuiTheme.buttonTextColor);
            button.setBackground(GuiTheme.backgroundColor1);
            button.setBorder(null);
        }
        bottomPanel = new JPanel();
        bottomPanel.setBackground(GuiTheme.backgroundColor1); // bg color
        bottomPanel.add(guiBottomPanel);
    }
    
    private void initCenterPanel() {
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setAlignmentY(CENTER_ALIGNMENT);
        centerPanel.add(guiProfile, BorderLayout.CENTER);
    }
    
    private void initProfilePanel() {
        guiProfile = new GuiProfile();
        guiProfile.getHeaderLabel().setFont(GuiTheme.fontHeader2);
        guiProfile.getHeaderPanel().setBackground(GuiTheme.backgroundColor2);
        guiProfile.getHeaderPanel().setPreferredSize(new Dimension(WIDTH,50));
        guiProfile.getHeaderPanel().setMaximumSize(new Dimension(WIDTH,50));
        
        guiProfile.getLabelBalance().setFont(GuiTheme.fontHeader2);
        guiProfile.getLabelBalance().setForeground(Color.white);
        guiProfile.getLabelBalance().setBackground(GuiTheme.panelBalance);
        guiProfile.getLabelPoint().setFont(GuiTheme.fontHeader2);
        guiProfile.getLabelPoint().setForeground(Color.white);
        guiProfile.getLabelPoint().setBackground(GuiTheme.panelBalance);
        
        JLabel[] labels = {
            guiProfile.getLabelName(),
            guiProfile.getLabelContact(),
            guiProfile.getLabelEmail(),
            guiProfile.getLabelAddress()
        };
        int contentWidth = (WIDTH-(WIDTH/6))/2;
        for(JLabel label: labels) { // set theme to buttons
            label.setFont(GuiTheme.fontContent);
            label.setAlignmentX(CENTER_ALIGNMENT);
            label.setPreferredSize(new Dimension(contentWidth, 50));
            label.setMaximumSize(new Dimension(contentWidth, 50));
                                          // WIDTH/6 refers to side bar
        }
        
        JButton[] buttons = {
            guiProfile.getButtonAddress(),
            guiProfile.getButtonNoti(),
            guiProfile.getButtonVouchers(),
            guiProfile.getButtonSettings(),
            guiProfile.getButtonLogOut()
        };
        for(JButton button: buttons) { // set theme to buttons
            button.setForeground(GuiTheme.buttonTextColor);
            button.setBackground(GuiTheme.buttonBackColor);
        }
    }
    
    private void initMenuPanel() {
        // String code, String name, float price, String remarks
        guiMenu = new GuiMenu(guiCart, order.getFoods(),order.getDrinks());
        guiMenu.getHeaderLabel().setFont(GuiTheme.fontHeader2);
        guiMenu.getHeaderPanel().setBackground(GuiTheme.backgroundColor2);
        guiMenu.getHeaderPanel().setPreferredSize(new Dimension(WIDTH,50));
        guiMenu.getHeaderPanel().setMaximumSize(new Dimension(WIDTH,50));
        
        guiMenu.getLabelFood().setFont(GuiTheme.fontContent);
        guiMenu.getLabelFood().setBackground(GuiTheme.backgroundColor2);
        guiMenu.getLabelDrink().setFont(GuiTheme.fontContent);
        guiMenu.getLabelDrink().setBackground(GuiTheme.backgroundColor2);
        
        for(JButton button: guiMenu.getFoodButtons()) {
            button.setFont(GuiTheme.fontContent2);
            button.setForeground(GuiTheme.buttonTextColor);
            button.setBackground(GuiTheme.buttonBackColor);
        }
        
        for(JButton button: guiMenu.getDrinkButtons()) {
            button.setFont(GuiTheme.fontContent2);
            button.setForeground(GuiTheme.buttonTextColor);
            button.setBackground(GuiTheme.buttonBackColor);
        }
    }
    
    private void initCartPanel() {
        guiCart = new GuiCart(order.getFoods(), order.getDrinks());
        guiCart.getHeaderLabel().setFont(GuiTheme.fontHeader2);
        guiCart.getHeaderPanel().setBackground(GuiTheme.backgroundColor2);
        guiCart.getHeaderPanel().setPreferredSize(new Dimension(WIDTH,50));
        guiCart.getHeaderPanel().setMaximumSize(new Dimension(WIDTH,50));
        
        JButton[] labels = {
            guiCart.getLabelPrice(), guiCart.getLabelPriceValue(),
            guiCart.getLabelDiscount(), guiCart.getLabelDiscountValue(),
            guiCart.getLabelTotal(), guiCart.getLabelTotalValue(),
            guiCart.getButtonPay(), guiCart.getButtonClear()
        };
        for(JButton label: labels) {
            label.setFont(GuiTheme.fontContent2);
            label.setForeground(GuiTheme.buttonTextColor);
            label.setBackground(GuiTheme.buttonBackColor);
        }
    }
    
    private void initFrame() {
        initTopPanel();
        initSidePanel();
        initBottomPanel();
        initProfilePanel();
        initCartPanel();
        initMenuPanel();
        initCenterPanel();

        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(sidePanel, BorderLayout.WEST);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        
        this.setSize(WIDTH, HEIGHT);
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case GuiSidePanel.PROFILE:
                centerPanel.removeAll();
                centerPanel.add(guiProfile);
                centerPanel.revalidate();
                centerPanel.repaint();
                break;
            case GuiSidePanel.MENU:
                centerPanel.removeAll();
                centerPanel.add(guiMenu);
                centerPanel.revalidate();
                centerPanel.repaint();
                break;
            case GuiSidePanel.CART:
                centerPanel.removeAll();
                guiCart.setVoucher(order.getVouchers().get(0));
                guiCart.getCartRows().clear();
                guiCart.getCartPanel().removeAll();
                guiCart.createCart();
                guiCart.setNewTotal();
                centerPanel.add(guiCart);
                centerPanel.revalidate();
                centerPanel.repaint();
                break;
        }
    }
}

class TesterGUI {
    public static void main(String args[]) {
        GuiMainFrame gui = new GuiMainFrame();
    }
}