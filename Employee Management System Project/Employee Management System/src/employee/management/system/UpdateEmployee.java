			
package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener{
       
    JTextField tfeducation, tffname, tfaddress, tfemail, tfsalary, tfphone, tfdesignation;
    JLabel lblempId;
    JButton update, back;
    String empId;//global declaration
    
    /*"new UpdateEmployee(cemployeeId.getSelectedItem());"
      this was throwing an error in the ViewEmployee frame so we had to pass "String empId "
      as an argument and also an empty string in the main()
      "new UpdateEmployee(cemployeeId.getSelectedItem());" the empId that was being passed there 
       in the ViewEmployee frame 
      is stored in this "String empId"*/
    UpdateEmployee(String empId){
        /*we storing the local variable(empId) to global variable(this.empId)*/
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        JLabel lblname = new JLabel();//we can't change name 
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150,30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel labeldob = new JLabel("DOB");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150,30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150,30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150,30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150,30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Education");
        labeleducation.setBounds(400, 300, 150,30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150,30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150,30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 400, 150,30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150,30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try {
            Conn c = new Conn();
            /*first empId is the column name 
              second empId is the global variable
              in simple words here the empId is working as a primary key to tell which 
              particular row are we going to work upon*/
            String query = "select * from EmpDetails where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);//executing the above query and storing it in rs
            /*all the rows being looped here*/
            while(rs.next()) {
                /*-"name"- is the column name
                 getString("name") this is taking the value from the database
                 lblname.setText this is storing that value in lblname and showing it on the screen*/
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("name"));   
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        update = new JButton("Update Details");
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
                
        
        setSize(900, 700);
        setLocation(180, 50);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == update){
            /*getText() is used here to get all the values inserted into the corresponding string
              this will help us to insert all the values in the database*/
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            try {
                Conn conn = new Conn();
                /*"update EmpDetails set fname ...." is a sql query
                 -fname = '"+fname+"'- frist fname is the column name, 
                second fname is storing the updated value to be inserted in the database
                -where empId = '"+empId+"'-this is telling at which row are we going to make the changes*/
                String query = "update EmpDetails set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"' ";
                /*since 'insert into EmpDetails values'is a DML command 
                  so executeUpdate is used*/                                             
                conn.s.executeUpdate(query);
                /*JOptionPane.showMessageDialog() is used to show a message on the screen*/
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new Home();
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        /*there is an empty string bcz "new UpdateEmployee(cemployeeId.getSelectedItem());" was 
          throwing an error in th ViewEmployee frame*/
        new UpdateEmployee("");
       
    }

    
}
