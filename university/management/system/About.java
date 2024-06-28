package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        addLabel("University Management System", 150, 20, 400, 50, new Font("Tahoma", Font.BOLD, 24));
        addLabel("Developed By:", 70, 100, 200, 30, new Font("Tahoma", Font.BOLD, 20));
        addLabel("2312408 - Muhammad Saad", 70, 140, 300, 30, new Font("Tahoma", Font.PLAIN, 18));
        addLabel("2312259 - Shayan Muhammad Faisal", 70, 180, 400, 30, new Font("Tahoma", Font.PLAIN, 18));
        addLabel("2312245 - Mohit Kumar", 70, 220, 300, 30, new Font("Tahoma", Font.PLAIN, 18));
        addLabel("2233333 - Mahad Baloch", 70, 260, 300, 30, new Font("Tahoma", Font.PLAIN, 18));
        addLabel("Contact: BSCS 2D(Group 2)", 70, 320, 300, 30, new Font("Tahoma", Font.PLAIN, 20));

        setVisible(true);
    }

    private void addLabel(String text, int x, int y, int width, int height, Font font) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(font);
        add(label);
    }

    public static void main(String[] args) {
        new About();
    }
}
