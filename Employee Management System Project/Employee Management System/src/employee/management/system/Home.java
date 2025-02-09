
package employee.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Home extends JFrame implements ActionListener{
    
    JButton add, view, update, remove;
    
    Home(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        add(heading);//if we use only this the heading will be behing the image
        image.add(heading);//to make the heading above the image
        
        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1120, 630);
        setLocation(75, 30);
        setVisible(true);
        
    }
    
    /*here we have one problem
      bcz here we have 4 buttons 
      so we need to clarify that at a click which button is hit
      for that ActionEvent class will help
      we are going to use the object of ActionEvent(ae) to differentiate*/
    public void actionPerformed(ActionEvent ae) {
        
        //getSource is telling us the source of the click
        //if source is equal to add, add button funtion will work
        if(ae.getSource() == add){ 
            setVisible(false);
            new AddEmployee();//this will open AddEmployee frame
            
        }else if(ae.getSource() == view){
            setVisible(false);
            new ViewEmployee();
        }else if(ae.getSource() == update){
            /*at the place of update we are putting ViewEployee bcz from there we will select 
              that particaular employee of whom we need to update the information
              and from there we are going to select that particular employee and update the detials*/
            setVisible(false);
            new ViewEmployee();
        }else{
            setVisible(false);
            new RemoveEmployee();
        }
       
    }
    
    public static void main(String args[]) {
       new Home();
    }

    
}
