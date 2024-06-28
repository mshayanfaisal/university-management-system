package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox<String> cbsemester;
    JTextField[] tfsub = new JTextField[5];
    JTextField[] tfmarks = new JTextField[5];
    JButton cancel, submit;
    
    EnterMarks() {
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 70, 150, 20);
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);
        loadRollNumbers();
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 110, 150, 20);
        add(lblsemester);
        
        String[] semester = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(200, 110, 150, 20);
        add(cbsemester);
        
        addLabel("Enter Subject", 100, 150, 200, 40);
        addLabel("Enter Marks", 320, 150, 200, 40);
        addTextFields();
        
        submit = addButton("Submit", 70, 360, 150, 25);
        cancel = addButton("Back", 280, 360, 150, 25);
        
        setVisible(true);
    }

    private void loadRollNumbers() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JLabel addLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        add(label);
        return label;
    }

    private void addTextFields() {
        int y = 200;
        for (int i = 0; i < 5; i++) {
            tfsub[i] = new JTextField();
            tfsub[i].setBounds(50, y, 200, 20);
            add(tfsub[i]);
            
            tfmarks[i] = new JTextField();
            tfmarks[i].setBounds(250, y, 200, 20);
            add(tfmarks[i]);
            
            y += 30;
        }
    }
    
    private JButton addButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.BOLD, 15));
        button.addActionListener(this);
        add(button);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();
                
                String query1 = String.format("insert into subject values('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    crollno.getSelectedItem(), cbsemester.getSelectedItem(), tfsub[0].getText(), tfsub[1].getText(), tfsub[2].getText(), tfsub[3].getText(), tfsub[4].getText());
                String query2 = String.format("insert into marks values('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    crollno.getSelectedItem(), cbsemester.getSelectedItem(), tfmarks[0].getText(), tfmarks[1].getText(), tfmarks[2].getText(), tfmarks[3].getText(), tfmarks[4].getText());
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
