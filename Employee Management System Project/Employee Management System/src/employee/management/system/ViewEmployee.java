
package employee.management.system;

import java.awt.Choice;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;//JTable is used to create tables
    Choice cemployeeId;//alternate for JComboBox, creates drop down box
    JButton search, print, update, back;
    Conn c;
    ResultSet rs;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        table = new JTable();
        
        try {
            c = new Conn();
            rs = c.s.executeQuery("select * from EmpDetails");
            
            /*doing this to insert the empId dynamically in the drop down box
              "while(rs.next())" all the rows are being looped here  
               and the value of "empId" from all the rows are being taken by the getString()
               and being sent to cemployeeId*/
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        try {
            c = new Conn();
            /*all the data coming from the database will be stored in the object of ResultSet() i.e., rs
              and we have to store that data in the JTable's object i.e., table
              bcz table will display that on the screen*/
            rs = c.s.executeQuery("select * from EmpDetails");
            /*to store the data in the JTable's object i.e., table we'll use
              table.setModel(DbUtils.resultSetToTableModel(rs)) this is taking the data stored in 
              rs and sending it to the table
              in simple words to show the data in the table*/
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        //JScrollPane() will create a scroll bar 
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        
        setSize(900, 700);
        setLocation(180, 50);
        setVisible(true);
        
               
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        //getSource is telling us the source of the click
        //if source is equal to search, print, update or back, respective funtion will work
        if(ae.getSource() == search){ 
            /*"select * from EmpDetails where empId" ye kehra hai 'cemployeeId mei jo empId hai usko uthaao'
               since cemployeeId is storing the empId in the drop down
               so "getSelectedItem()" will take this empId and send it to "String query"*/
            String query = "select * from EmpDetails where empId = '"+cemployeeId.getSelectedItem()+"' ";
            try {
                c = new Conn();
                /*executing the query and storing the entire row for that empId in rs*/
                rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));//storing the row in the table
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == print){
            try {
                table.print();//to print the data
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == update){
            setVisible(false);
            /*"cemployeeId.getSelectedItem()" this will pass empId in the UpdateEmployee frame*/
            new UpdateEmployee(cemployeeId.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
            
    }

       public static void main(String args[]) {
        new ViewEmployee();
    }

}
