
package employee.management.system;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*JFrame class is used to create a frame
  ActionListener interface is used to turn on the click action of the 
  "click here continue" button 
  but ActionListener contains some abstract methods which is to be overridden here
  The abstract method
         public void actionPerformed(ActionEvent ae){
        
    }
        */
public class Splash extends JFrame implements ActionListener {
    
    /*we have created a default constructed here bcz we'll do our work in it only*/
    /*mai kya chahta hu ki jaise hi mai file ko run karu to jo frame hai wo dikhne lag jaiye
    lekin class ko run krte hi main method call hota aur usmei object hai jiska constructor
    call hoga but "mai kya chahta hu ki jaise hi mai file ko run karu to jo frame hai wo 
    dikhne lag jaiye"
    isliye hi sare coding constructor mei horri hai*/
    Splash(){
        
        getContentPane().setBackground(Color.WHITE);//to change color of the frame
        setLayout(null); /*the component("EMPLOYEE MANAGEMENT SYSTEM") is shown in 
                           left centre
                           want that according to me
                           layout will help in that  
                           but swing has its own pre-defined layouts 
                           wanna use mine, so this*/
        
        /*to write anything on the frame but won't be visible/added
          use add() to make the component visible */
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);/*adjusting the place of the component
                                              (left, top, lenght, width)*/
        heading.setFont(new Font("serif", Font.PLAIN, 60)); /*to control the font*/
        heading.setForeground(Color.RED); // font color change of componet
        add(heading);
               
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
                /*Imageicone class is used to add image on the background of the frame
                  ClassLoader is used to pick image from the folder
                  getSystemResource method takes the address of the image*/
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
                /*the size of image is different, need to be scaled
                  but this scaled image can't be added directly needs to be sent 
                  back to the ImageIcone class*/
        ImageIcon i3 = new ImageIcon(i2); 
                /*since JLabel only takes ImageIcon's object
                  sent back to ImageIcon class*/        
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500); //puts the image at the right place
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE CONTINUE");
                /*JButton class is used add buttons*/
        clickhere.setBounds(400, 400, 300, 70);//sets button location
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        /*when we'll click on 'click here continue' button, 
          ActionListerner function will call the click event*/
        clickhere.addActionListener(this);
        image.add(clickhere);//puts button with respect to the image
        
        
        setSize(1170, 650); //size of the frame,but not visible
        setVisible(true); //making frame visible
        setLocation(50, 25); //frame always open from top left corner, decides the location
        
        while(true) { //to make the heading blick infinite while loop is used
            heading.setVisible(true); //makes it visible
            try{
               Thread.sleep(500);//visible for 500 mili second
            }catch(Exception e){
                
            }
            
            heading.setVisible(false);//maked it invisible
            try{
               Thread.sleep(500);//invisible for 500 mili second
            }catch(Exception e){
                
            }
        }
    }
    /*From ActionListener interface, actionPerformed method is called 
      and perfroms 2 actions*/
    public void actionPerformed(ActionEvent ae){
        setVisible(false);//closes the splash frame
        new Login();//opens the login frame
    }

    
    public static void main(String args[]) {
        /*when the program is run the main method is called which has only the 
          splash method
          due to this splash method, its constructor will come into action*/
        new Splash();
    }
}
