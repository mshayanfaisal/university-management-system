package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JFrame implements ActionListener {
    
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit, cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    AddStudent() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        addLabel("New Student Details", 310, 30, 500, 50, 30);
        addLabel("Name", 50, 150, 100, 30, 20);
        addLabel("Father's Name", 400, 150, 200, 30, 20);
        addLabel("Roll Number", 50, 200, 200, 30, 20);
        addLabel("Date of Birth", 400, 200, 200, 30, 20);
        addLabel("Address", 50, 250, 200, 30, 20);
        addLabel("Phone", 400, 250, 200, 30, 20);
        addLabel("Email Id", 50, 300, 200, 30, 20);
        addLabel("Class X (%)", 400, 300, 200, 30, 20);
        addLabel("Class XII (%)", 50, 350, 200, 30, 20);
        addLabel("CNIC Number", 400, 350, 200, 30, 20);
        addLabel("Course", 50, 400, 200, 30, 20);
        addLabel("Branch", 400, 400, 200, 30, 20);
        
        tfname = addTextField(200, 150, 150, 30);
        tffname = addTextField(600, 150, 150, 30);
        labelrollno = addLabel("1533" + first4, 200, 200, 200, 30, 20);
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        tfaddress = addTextField(200, 250, 150, 30);
        tfphone = addTextField(600, 250, 150, 30);
        tfemail = addTextField(200, 300, 150, 30);
        tfx = addTextField(600, 300, 150, 30);
        tfxii = addTextField(200, 350, 150, 30);
        tfaadhar = addTextField(600, 350, 150, 30);
        
        String[] courses = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = addComboBox(courses, 200, 400, 150, 30);
        
        String[] branches = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbbranch = addComboBox(branches, 600, 400, 150, 30);
        
        submit = addButton("Submit", 250, 550, 120, 30);
        cancel = addButton("Cancel", 450, 550, 120, 30);
        
        setVisible(true);
    }
    
    private JLabel addLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("serif", Font.BOLD, fontSize));
        add(label);
        return label;
    }
    
    private JTextField addTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        add(textField);
        return textField;
    }
    
    private JComboBox<String> addComboBox(String[] items, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(x, y, width, height);
        comboBox.setBackground(Color.WHITE);
        add(comboBox);
        return comboBox;
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            
            try {
                String query = String.format("insert into student values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
                                              name, fname, rollno, dob, address, phone, email, x, xii, aadhar, course, branch);

                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddStudent();
    }
}
