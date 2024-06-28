package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;
    
    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        add(image);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        for (int i = 2, x = 1; i <= 600; i += 4, x++) {
            setLocation(600 - (i + x) / 2, 350 - i / 2);
            setSize(i + 3 * x, i + x / 2);
            
            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }
    
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        } catch (Exception e) {}
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}
