
package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton delete, back;
    
    RemoveEmployee() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);
        
        try {
            Conn c = new Conn();
            String query = "select * from EmpDetails";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                /*empId is sending data in cEmpId*/
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 200, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 200, 30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 200, 30);
        add(lblemail);
        
        try {
            Conn c = new Conn();
            /*-empId = '"+cEmpId.getSelectedItem()+"'- using getSelectedItem() cEmpId is storing 
             the value in empId*/
            String query = "select * from EmpDetails where empId = '"+cEmpId.getSelectedItem()+"' ";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                /*the column name "phone is storing its value in lblphone"*/
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /*here ItemListener() is checking if the value in the drop down of Employee Id has changed or not*/
        cEmpId.addItemListener(new ItemListener() {
            
            public void itemStateChanged(ItemEvent ie) {//abstract method of ItemListener
                /*this will help in changing name,phone and email according to drop down */
                try {
                    Conn c = new Conn();
                    /*-empId = '"+cEmpId.getSelectedItem()+"'- using getSelectedItem() cEmpId is storing 
                     the value in empId*/
                    String query = "select * from EmpDetails where empId = '"+cEmpId.getSelectedItem()+"' ";
                    ResultSet rs = c.s.executeQuery(query);

                    while(rs.next()) {
                        /*the column name "phone is storing its value in lblphone"*/
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }  
                
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400); 
        add(image);
        
        setSize(1000, 400);
        setLocation(140, 150);
        setVisible(true);

    }   
    
    public void actionPerformed(ActionEvent ae) {
        /*for deleting the data the we are going to use Delete command*/
        if (ae.getSource() == delete) {
            try {
               Conn c = new Conn();
               /*delete query */
               String query = "delete from EmpDetails where empId = '"+cEmpId.getSelectedItem()+"' ";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Employee Details Deleted Successfully");
               setVisible(false);
               new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
       new RemoveEmployee();
    }

    
}
