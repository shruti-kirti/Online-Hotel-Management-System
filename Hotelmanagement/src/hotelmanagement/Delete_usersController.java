
package hotelmanagement;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class Delete_usersController implements Initializable {

   @FXML
    private Label label;
    @FXML
    private TextField t1;
    @FXML
    private Button b1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void handleButtonActionb1(ActionEvent event) {
        String u=t1.getText();
        if ("".equals(t1.getText())){
             Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Fill the username ...");
            alert.setTitle("Error");
     
            alert.showAndWait();
            return;
        }
         PreparedStatement pst;
ResultSet rs;
        try        
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Mamtavinod40*");
            Statement s = con.createStatement();
            pst=con.prepareStatement("select * from data1 where username=?;");
                pst.setString(1,u);
 rs=pst.executeQuery();
  if(rs.next())
                {
            JOptionPane.showMessageDialog(null, "User is deleted");
             }else{JOptionPane.showMessageDialog(null, "Username is invalid"); }
            String s1="delete from data1 where username=('"+u+"')";
             System.out.println("sucess"); 
            s.executeUpdate(s1); 
           
             }
        catch(Exception e)
        {System.out.println(e);
        JOptionPane.showMessageDialog(null, "Username is invalid");} 
        }
}
