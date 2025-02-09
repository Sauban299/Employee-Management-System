package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername,tfpassword;
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");//to write 'Username' on the frame
        lblusername.setBounds(40, 20, 100, 30);//setting location of 'Username'
        add(lblusername);//making 'Username visible
        
        /*earlier we used "JTextField tfusername = new JTextField();"
          but not 'tfusername' has to be accessed globally
          so declared before the constructor so that method 'actionPerformed'
          can access it*/
        //JTextField tfusername = new JTextField();//creating input box for the username
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);//setting location for the box
        add(tfusername);//making input box visible
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);//bounds are changed to be save from overlapping
        add(lblpassword);
        
        /*earlier we used "JTextField tfpassword = new JTextField();"
          but not 'tfpassword' has to be accessed globally
          so declared before the constructor so that method 'actionPerformed'
          can access it*/
        //JTextField tfpassword = new JTextField();
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        JButton login = new JButton("LOGIN");//to create login button
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    
    /*Overriden method of interface ActionListener
      the username's and password's input box is used to verify the admin 
      so the information given has to be matched to some stored value 
      matching work is done using the actionPerformed method*/
    public void actionPerformed(ActionEvent ae){
        /*try-catch is used to exception handling as mysql is external entity*/
        try{
            /*getText() help us to tell the value which is given in the text field */
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            /*here we are creating mysql query
              'select * from login where' bcz we are checking all the data from login table
              ' username = '"+username+"' ' 
                first username is an attribute from login table
                secong username is from tfusername(just above)
                ++ is for concatinate
                "" bcz we pass value using this only
                '' is used bcz the attribute username is varchar string*/
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";//creating sql query
            
            /*executeQuery method is used to execute the (DDL command) sql query so executeQuery is used
              but executeQuery() is used thorugh 's = c.createStatement()(in the Conn.java file)'
              and to use 's = c.createStatement();' we need to create an object of the Conn class
              so that we can access the statement from there
              'c.s.' Conn class ke object(c) se statement ko call kra and statement se executeQuery() ko
              'c.s.executeQuery(query)' this will return some value, mila hai to kya - nii mila hai to kya
              this value has to be stored in the object of ResultSet i.e., in 'ResultSet rs' */
            ResultSet rs = c.s.executeQuery(query);//executing sql query
                    
                    /*this is to check what is given inside the object rs
                      incase rs is kept empty esle statement will run*/
                    if(rs.next()) {
                        setVisible(false);
                        //we have created object of Home class 
                        //that means for the right password, home frame will appear
                        new Home();
                    } else {
                        /*if the value given in rs is wrong, pop up message will come*/
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                        //and close the frame
                       // setVisible(false);
                    }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
