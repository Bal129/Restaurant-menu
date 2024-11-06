package ooadfinal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Iqbal
 */
public class GuiCart extends JPanel {
    public static final String HEADER = "Cart";
    public static final String PAY = "Pay";
    public static final int CART_ROW_LABEL = 0;
    public static final int CART_ROW_PRICE = 1;
    public static final int CART_ROW_QUANTITY = 2;
    public static final int CART_ROW_REMOVE = 3;
    private JPanel headerPanel;
    private JPanel cartPanel;
    private JPanel bottomPanel;
    private JScrollPane contentPanelScroll;
    private GridBagConstraints bottomConstraints = new GridBagConstraints();
    
    // components for top panel
    
    private JLabel headerLabel;

    // components for cart panel
    
    private LinkedList<JPanel> cartRows;
    private HashSet<Cart> carts;
    
    // components for bottom panel
    private DecimalFormat decimalFormat;
    private float valuePrice = 0;
    private float valueDiscount = 0;
    private float valueTotal = 0;
    private Voucher voucher;
    private JButton labelPrice;
    private JButton labelDiscount;
    private JButton labelTotal;
    private JButton labelPriceValue;
    private JButton labelDiscountValue;
    private JButton labelTotalValue;
    private JTextField textDiscount;
    private String discountCode;
    private JButton buttonPay;
    private JButton buttonClear;
    
    // components for popup paid frame
    
    private JFrame paidPopup;
    private JLabel labelPopup;
    
    // methods
    
    public GuiCart(ArrayList<Food> foods, ArrayList<Drink> drinks) {
        this.setLayout(new BorderLayout(10, 10));
        initTop();
        initBottom();
        initCartPanel();
        this.add(contentPanelScroll, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initTop() {
        headerPanel = new JPanel();
        headerLabel = new JLabel(HEADER);
        headerPanel.add(headerLabel);
        this.add(headerPanel, BorderLayout.NORTH);
    }
    
    private void initBottom() {
        decimalFormat = new DecimalFormat("0.00");
        bottomPanel = new JPanel(new GridBagLayout());
        labelPrice = new JButton("Price");
        labelDiscount = new JButton("Discount");
        labelTotal = new JButton("Total");
        labelPriceValue = new JButton("RM"+decimalFormat.format(valuePrice));
        labelDiscountValue = new JButton("RM"+decimalFormat.format(valueDiscount));
        labelTotalValue = new JButton("RM"+decimalFormat.format(valueTotal));
        
        textDiscount = new JTextField("Discount");
        textDiscount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                discountCode = textDiscount.getText();
            }
        });
        
        buttonPay = new JButton("Pay");
        JButton[] labels = {
            labelPrice, labelPriceValue, 
            labelDiscount, labelDiscountValue,
            labelTotal, labelTotalValue
        };
        
        int column = 0;
        int row = 0;
        bottomConstraints.insets = (new Insets(5,10,5,10));
        bottomConstraints.gridx = column = 2;
        bottomConstraints.gridy = row++;
        bottomConstraints.gridheight = 99;
        bottomConstraints.fill = GridBagConstraints.VERTICAL;
        buttonPay.setPreferredSize(new Dimension(200,50));
        buttonPay.addActionListener(new payButton());
        bottomPanel.add(buttonPay, bottomConstraints);
        
        buttonClear = new JButton("Clear");
        bottomConstraints.gridx = ++column;
        buttonClear.setPreferredSize(new Dimension(80,50));
        buttonClear.addActionListener(new removeButton());
        bottomPanel.add(buttonClear, bottomConstraints);
        
        bottomConstraints.insets = (new Insets(5,2,5,0));
        bottomConstraints.gridx = column = 0;
        bottomConstraints.fill = GridBagConstraints.RELATIVE;
        bottomConstraints.gridheight = 1;
        for(JButton label: labels) {
            bottomConstraints.gridx = column++;
            bottomConstraints.gridy = row;
            label.setPreferredSize(new Dimension(200,50));
            bottomPanel.add(label, bottomConstraints);
            if(column%2 == 0) {column = 0; row++;} // to set 2 columns per row only
        }
    }
    
    public void initCartPanel() {
        cartPanel = new JPanel();
        cartPanel.setLayout(new GridLayout(0,4));
        contentPanelScroll = new JScrollPane(
            cartPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        cartRows = new LinkedList<>();
        carts = new HashSet<>();
    }
    
    public void createCart() {
        int i = 0;
        for(Cart cart: carts) {
            JPanel panel = new JPanel();
            panel.add(new JLabel(cart.getName()));
            panel.add(new JLabel(""+cart.getQuantity()));
            panel.add(new JLabel(""+cart.getPrice()));
            i++;
            cartRows.add(panel);
        }
        System.out.println(cartRows);
        for(JPanel row: cartRows) {
            cartPanel.add(row);
        }
        System.out.println(contentPanelScroll.getComponentCount());
        repaint();
    }
    
    public void addCart(Cart newCart) {
        boolean found = false;
        for(Cart cart: carts) {
            if(cart.getName().equals(newCart.getName())) {
                found = true;
                int quantity = cart.getQuantity();
                cart.setQuantity(++quantity);
                break;
            }
        }
        if(!found) carts.add(newCart);
    }
    
    // nested classes
    
    class removeButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            cartRows.clear();
            carts.clear();
            refreshCart();
            
            setNewTotal();
        }
    }
    
    class payButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(valuePrice > 0) {
                labelPopup = new JLabel("Successfully Paid");
                labelPopup.setFont(GuiTheme.fontContent2);
                paidPopup = new JFrame();
                paidPopup.add(labelPopup);
                paidPopup.setSize(200,200);
                paidPopup.setLocationRelativeTo(null);
                paidPopup.setVisible(true);
                paidPopup.setAlwaysOnTop(true);

                cartRows.clear();
                carts.clear();
                refreshCart();
                valuePrice = 0;
                valueDiscount = 0;
                valueTotal = 0;

                setNewTotal();
            }
        }
    }
    
    public void refreshCart() {
        cartPanel.removeAll();
        cartPanel.revalidate();
        cartPanel.repaint();
    }
    
    public void setNewTotal() {
        float sum = 0;
        for(Cart cart: carts) {  // calculate total price
            sum += cart.getPrice()*cart.getQuantity();
        }
        valuePrice = sum;
        valueTotal = voucher.calculatePrice(valuePrice);
        valueDiscount = valuePrice - valueTotal;
        labelPriceValue.setText("RM"+decimalFormat.format(valuePrice));
        labelDiscountValue.setText("RM"+decimalFormat.format(valueDiscount));
        labelTotalValue.setText("RM"+decimalFormat.format(valueTotal));
        labelPriceValue.revalidate(); labelPriceValue.repaint();
        labelDiscountValue.revalidate(); labelDiscountValue.repaint();
        labelTotalValue.revalidate(); labelTotalValue.repaint();
    }
    
    // getters

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public JLabel getHeaderLabel() {
        return headerLabel;
    }

    public JButton getLabelPrice() {
        return labelPrice;
    }

    public JButton getLabelDiscount() {
        return labelDiscount;
    }

    public JButton getLabelTotal() {
        return labelTotal;
    }

    public JButton getLabelPriceValue() {
        return labelPriceValue;
    }

    public JButton getLabelDiscountValue() {
        return labelDiscountValue;
    }

    public JButton getLabelTotalValue() {
        return labelTotalValue;
    }

    public JButton getButtonPay() {
        return buttonPay;
    }

    public JLabel getLabelPopup() {
        return labelPopup;
    }

    public JButton getButtonClear() {
        return buttonClear;
    }

    public HashSet<Cart> getCarts() {
        return carts;
    }

    public JPanel getCartPanel() {
        return cartPanel;
    }

    public LinkedList<JPanel> getCartRows() {
        return cartRows;
    }
    
    public Voucher getVoucher() {
        return voucher;
    }
    
    // setters

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }    
}
