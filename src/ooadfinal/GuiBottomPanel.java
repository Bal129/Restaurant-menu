package ooadfinal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Iqbal
 */
public class GuiBottomPanel extends JPanel {
    private static int width;
    private static int height;
    public static final String FIND_US = "Find Us";
    public static final String CUS_SERVICE = "Customer Service";
    public static final String FAQ = "FAQ";
    public static final String HALAL = "Halal";
    public static final String ABOUT_US = "About Us";
    private JButton btnFindUs = new JButton(FIND_US);
    private JButton btnCustomerService = new JButton(CUS_SERVICE);
    private JButton btnFaq = new JButton(FAQ);
    private JButton btnHalal = new JButton(HALAL);
    private JButton btnAboutUs = new JButton(ABOUT_US);

    // constructor
    
    public GuiBottomPanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        initPanel();
    }
    
    // methods
    
    private void initPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        this.setAlignmentY(Component.BOTTOM_ALIGNMENT);
                
        JButton[] buttons = {btnFindUs, btnCustomerService, btnFaq, btnHalal, btnAboutUs};
        for(JButton button: buttons) {
            button.setPreferredSize(new Dimension(175,height));
            button.setAlignmentY(Component.BOTTOM_ALIGNMENT);
            this.add(button);
        }
    }
    
    // getters
    
    public JButton getBtnFindUs() {
        return btnFindUs;
    }

    public JButton getBtnCustomerService() {
        return btnCustomerService;
    }

    public JButton getBtnFaq() {
        return btnFaq;
    }

    public JButton getBtnHalal() {
        return btnHalal;
    }

    public JButton getBtnAboutUs() {
        return btnAboutUs;
    }
    
    // setters

    public void setBtnFindUs(JButton btnFindUs) {
        this.btnFindUs = btnFindUs;
    }

    public void setBtnCustomerService(JButton btnCustomerService) {
        this.btnCustomerService = btnCustomerService;
    }

    public void setBtnFaq(JButton btnFaq) {
        this.btnFaq = btnFaq;
    }

    public void setBtnHalal(JButton btnHalal) {
        this.btnHalal = btnHalal;
    }

    public void setBtnAboutUs(JButton btnAboutUs) {
        this.btnAboutUs = btnAboutUs;
    }
}