
/*FIVE STEP OF JDBC 
        Register the Driver class
	Creating the connection String
	Creating statement 
	Executing mysql queries 
	Closing the connections*/

package employee.management.system;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    
    Connection c;//connection is an interface which is used to create connection String
    Statement s;//statement is an interface used to create statements
    
    public Conn(){
        /*we used try-catch for exception handling since
          mySql is an external entity, so to be save from errors */
        try {
            /*forName() is used to regiested the Driver of mysql*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*DriverMaganer class is also helping in creating the connection string*/
            c = DriverManager.getConnection("jdbc:mysql:///employmeemanagementsystem", "root", "Saub@123");
            s = c.createStatement();//connection string is used to create statements 
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
