package ooadfinal;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Iqbal
 */
public abstract class GuiTheme {
    public static final Font fontHeader = new Font(Font.SANS_SERIF, Font.BOLD, 40);
    public static final Font fontHeader2 = new Font(Font.SANS_SERIF, Font.BOLD, 30);
    public static final Font fontContent = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    public static final Font fontContent2 = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    public static final Font fontButton1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
    public static final Font fontButton2 = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
    
    public static final Color buttonTextColor = new Color(204, 0, 65);
    public static final Color buttonBackColor = new Color(227, 226, 223);
    public static final Color backgroundColor1 = new Color(241, 218, 224);
    public static final Color backgroundColor2 = new Color(220, 163, 178);
    public static final Color panelBalance = new Color(204, 122, 0);
}


//public class GuiTheme extends JFrame {
//    public static final Color buttonTextColor = new Color(204, 0, 65);
//    public static final Color buttonBackColor = new Color(227, 226, 223);
//    public static final Color backgroundColor1 = new Color(241, 218, 224);
//    public static final Color backgroundColor2 = new Color(220, 163, 178);
//    
//    
//    // dummy window to test
//    
//    public GuiTheme() {};
//    
//    public void init() {
//        JPanel p = new JPanel();
//        JButton b = new JButton();
//
//        b.setText("Button");
//        b.setForeground(buttonTextColor);
//        b.setBackground(buttonBackColor);
//        b.setSize(new Dimension(150,100));
//        
//        p.add(b);
//        p.setBackground(backgroundColor2);
//        
//        this.add(p);
//        this.setSize(300,200);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//    }
//}
//
//class TestColor {
//    
//    public static void main(String args[]){
//        GuiTheme g = new GuiTheme();
//        g.init();
//    }
//}
