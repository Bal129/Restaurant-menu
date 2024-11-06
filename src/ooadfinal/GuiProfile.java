package ooadfinal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
public class GuiProfile extends JPanel {
    private static final String HEADER = "Profile";
    private static final String NOTI = "Noti";
    private static final String VOUCHER = "Voucher";
    private static final String SETTINGS = "Settings";
    private static final String LOG_OUT = "Log Out";
    private JPanel headerPanel;
    private JPanel contentPanel;
    private static int currentX = 0;
    private static int currentY = 0;
    private GridBagConstraints constraints = new GridBagConstraints();
    // GridBagConstraitns => to manipulate grid coordinates
    
    // components for top panel
    private JLabel headerLabel;
            
    // components for right panel
    private JPanel panelButtons;
    private JButton buttonNoti;
    private JButton buttonVouchers;
    private JButton buttonSettings;
    private JButton buttonLogOut;
    private JFrame discountWindow;
    
    // components for left panel
    private JButton labelBalance;
    private JButton labelPoint;
    private JLabel labelName;
    private JLabel labelContact;
    private JLabel labelEmail;
    private JLabel labelAddress;
    private JButton buttonAddress;
    
    public GuiProfile() {
        this.setLayout(new BorderLayout(10,10));
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        constraints.insets = new Insets(5,5,5,5);
        this.add(contentPanel, BorderLayout.CENTER);
        initTop();
        initLeftContent();
        initRightContent();
    }
    
    private void initTop() {
        headerPanel = new JPanel();
        headerLabel = new JLabel(HEADER);
        headerPanel.add(headerLabel);
        this.add(headerPanel, BorderLayout.NORTH);
    }
    
    private void initRightContent() {
        panelButtons = new JPanel(new GridLayout(4,0,10,10));
        buttonNoti = new JButton(NOTI);
        buttonVouchers = new JButton(VOUCHER);
        buttonSettings = new JButton(SETTINGS);
        buttonLogOut = new JButton(LOG_OUT);
        
        Component components[] = {
            buttonNoti, buttonVouchers, buttonSettings, buttonLogOut
        };
        for(Component component: components) {
            component.setPreferredSize(new Dimension(90,50));
            component.setMaximumSize(new Dimension(90,50));
            panelButtons.add(component);
        }
        constraints.gridheight = 99;
        constraints.gridx = currentX = 2;
        constraints.gridy = currentY = 0;
        contentPanel.add(panelButtons, constraints);
    }
    
    private void initLeftContent() {      
        labelBalance = new JButton("Balance: RM0.00");
        labelPoint = new JButton("Points: 0");
        labelName = new JLabel("Name: Customer");
        labelContact = new JLabel("Contact: 011-0000000");
        labelEmail = new JLabel("Email: customer@mail.com");
        labelAddress = new JLabel("Address: MMU Cyberjaya, Selangor");
        buttonAddress = new JButton("Change Address");
        
        // balance and point row
        
        constraints.gridheight = 1;
        constraints.gridx = currentX = 0;
        constraints.gridy = currentY = 0;
        labelBalance.setPreferredSize(new Dimension(300,50));
        labelBalance.setMaximumSize(new Dimension(300,50));
        contentPanel.add(labelBalance, constraints);
        
        constraints.gridx = ++currentX;
        constraints.gridy = currentY;
        labelPoint.setPreferredSize(new Dimension(200,50));
        labelPoint.setMaximumSize(new Dimension(200,50));
        contentPanel.add(labelPoint, constraints);
                        
        // name, contact, email, address rows
        
        Component components[] = {
            labelName, labelContact, labelEmail, labelAddress
        };
        
        constraints.gridwidth = 2; // set all rows beloww to 2 columns
        constraints.gridx = currentX = 0;
        for(Component component: components) {
            constraints.gridy = ++currentY;
            component.setPreferredSize(new Dimension(200,30));
            component.setMaximumSize(new Dimension(200,30));
            contentPanel.add(component, constraints);
        }
        
        // setup address button
        
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridy = ++currentY;
        contentPanel.add(buttonAddress, constraints);
        buttonAddress.setAlignmentX(Component.RIGHT_ALIGNMENT);
        buttonAddress.setPreferredSize(new Dimension(150, 30));
        buttonAddress.setMaximumSize(new Dimension(150, 30));
    }
    
    // getters

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public JButton getLabelBalance() {
        return labelBalance;
    }

    public JButton getLabelPoint() {
        return labelPoint;
    }

    public JLabel getLabelName() {
        return labelName;
    }

    public JLabel getLabelContact() {
        return labelContact;
    }

    public JLabel getLabelEmail() {
        return labelEmail;
    }

    public JLabel getLabelAddress() {
        return labelAddress;
    }

    public JButton getButtonAddress() {
        return buttonAddress;
    }

    public JLabel getHeaderLabel() {
        return headerLabel;
    }

    public JButton getButtonNoti() {
        return buttonNoti;
    }

    public JButton getButtonVouchers() {
        return buttonVouchers;
    }

    public JButton getButtonSettings() {
        return buttonSettings;
    }

    public JButton getButtonLogOut() {
        return buttonLogOut;
    }
}
