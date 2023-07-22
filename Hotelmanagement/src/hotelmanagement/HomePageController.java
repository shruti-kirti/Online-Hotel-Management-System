/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class HomePageController implements Initializable {
public static Stage window;
@FXML
    private Label label;
@FXML
    private Button b1;
@FXML
    private Button b2;
@FXML
    private Button b3;
@FXML
    private Button b4;
   @FXML
    private Button b5;
   @FXML
    private Button b6; 
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void handleButtonActionb1(ActionEvent event) {
        try{
Parent root= FXMLLoader.load(getClass().getResource("RoomBooking.fxml"));
Scene scene=new Scene(root);
window = new Stage();
window.setScene(scene);
window.show();
        }
        catch (Exception e) {
            System.out.println(e);
}
}
    @FXML
    private void handleButtonActionb5(ActionEvent event) {
        try{
Parent root= FXMLLoader.load(getClass().getResource("AddUser.fxml"));
Scene scene=new Scene(root);
window = new Stage();
window.setScene(scene);
window.show();
        }
        catch (Exception e) {
            System.out.println(e);
}
}
 @FXML
    private void handleButtonActionb2(ActionEvent event) {
        try{
Parent root= FXMLLoader.load(getClass().getResource("check_in.fxml"));
Scene scene=new Scene(root);
window = new Stage();
window.setScene(scene);
window.show();
        }
        catch (Exception e) {
            System.out.println(e);
}
} 
    @FXML
    private void handleButtonActionb3(ActionEvent event) {
        try{
Parent root= FXMLLoader.load(getClass().getResource("check_out.fxml"));
Scene scene=new Scene(root);
window = new Stage();
window.setScene(scene);
window.show();
        }
        catch (Exception e) {
            System.out.println(e);
}
}
   
    @FXML
    private void handleButtonActionb6(ActionEvent event) {
        try{
Parent root= FXMLLoader.load(getClass().getResource("delete_users.fxml"));
Scene scene=new Scene(root);
window = new Stage();
window.setScene(scene);
window.show();
        }
        catch (Exception e) {
            System.out.println(e);
}
} 
    @FXML
    private void handleButtonActionb4(ActionEvent event) {
        try{
Parent root= FXMLLoader.load(getClass().getResource("view_guests.fxml"));
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
