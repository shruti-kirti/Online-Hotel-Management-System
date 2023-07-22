/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;



import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



/**
 *
 * @author Shruti
 */
public class FXMLDocumentController implements Initializable  {
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
    private void handleButtonActionb1(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
       
        PreparedStatement pst;
ResultSet rs;
    
        String a=t1.getText();
        String b=p1.getText();
        if ("".equals(t1.getText()) || "".equals(p1.getText())) {
            JOptionPane.showMessageDialog(null, "Username or password not found");
        }
        else{
            try{
Class.forName("com.mysql.jdbc.Driver");  
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Mamtavinod40*");
          {
                pst=con.prepareStatement("select * from data1 where username=? and password=?;");
                pst.setString(1,a);
                pst.setString(2,b);
                rs=pst.executeQuery();
            
                
                if(rs.next())
                {
                    Parent root= FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                    Scene scene=new Scene(root);
                    window = new Stage();
                    window.setScene(scene);
                    window.show();}
                else
                    JOptionPane.showMessageDialog(null, "Usename or password is wrong");
            }
}
catch(SQLException e) {
System.out.println(e.getMessage());
}}  }}   
             



   
   
       
    

