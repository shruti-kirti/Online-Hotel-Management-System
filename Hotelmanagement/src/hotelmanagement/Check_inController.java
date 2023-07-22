
package hotelmanagement;

import static hotelmanagement.RoomBookingController.window;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class Check_inController implements Initializable {

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
            alert.setHeaderText("Fill the booking id ...");
            alert.setTitle("Error");
     
            alert.showAndWait();
            return;
        }
        
        try        
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Mamtavinod40*");
            Statement s = con.createStatement();
             String s1 = "insert into check_in(bid) values('"+u+"')";
             System.out.println("sucess"); 
            s.executeUpdate(s1); 
            JOptionPane.showMessageDialog(null, "Checked in successfully");
             }
        catch(Exception e)
        {System.out.println(e);
        JOptionPane.showMessageDialog(null, "Booking id is invalid");} 
        }
    @FXML
    private void handleButtonActionb2(ActionEvent event) {
    try{
Parent root= FXMLLoader.load(getClass().getResource("Booking_details.fxml"));
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

