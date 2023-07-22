
package hotelmanagement;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class AddUserController implements Initializable {

    public static Stage window;
   
    @FXML
    private Label label;
    @FXML
    private TextField t1;
     @FXML
    private PasswordField p1;
     @FXML
   
        @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
 
    @FXML
    private void handleButtonActionb1(ActionEvent event) {
        String u=t1.getText();
        String p=p1.getText();
        if ("".equals(t1.getText()) || "".equals(p1.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Fill all fields ...");
            alert.setTitle("Error");
     
            alert.showAndWait();
            return;
        }
        try        
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Mamtavinod40*");
            Statement s = con.createStatement();
             String s1 = "insert into data1(username,password) values ('"+u+"','"+p+"');";
             System.out.println("sucess"); 
            s.executeUpdate(s1); 
            JOptionPane.showMessageDialog(null, "User added successfully");
             }
        catch(Exception e)
        {System.out.println(e);JOptionPane.showMessageDialog(null, "Duplicate Username not allowed");} 
        
       p1.setText("");
            t1.setText("");
            
            } 
        
    public void movem(ActionEvent event){
        try{
Parent root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
Scene scene=new Scene(root);
window = new Stage();
window.setScene(scene);
window.show();
        }
        catch (Exception e) {
            System.out.println(e);
}
}
    
}
