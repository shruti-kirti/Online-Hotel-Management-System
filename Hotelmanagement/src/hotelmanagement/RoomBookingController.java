
package hotelmanagement;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RoomBookingController implements Initializable {
    ObservableList types = FXCollections.observableArrayList();
public static Stage window;
   
    @FXML
    private Label label;
    @FXML
    private TextField t1;
     @FXML
    private RadioButton r1;
      @FXML
    private RadioButton r2;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private ChoiceBox<String> choicebox;
    @FXML
    private TextField t5;
     @FXML
    private TextField t6;
      @FXML
    private TextField t7;
    @FXML
    private DatePicker d1;
    @FXML
    private DatePicker d2;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    
    @FXML
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        additems();
    }
    public void additems()
            {
            String q="AC Deluxe";
            String s="Non AC Deluxe";
            String d3 = "AC Non Deluxe";
            String d4="Non AC Non Deluxe";
            types.addAll(q,s,d3,d4);choicebox.getItems().addAll(types);}
    
    @FXML
    private void handleButtonActionb1(ActionEvent event) {
        
    String a=t1.getText();
    
    String c=t2.getText();
    String d=t3.getText();
    String e1=t4.getText();
    String f = (choicebox.getValue());
    String g= t5.getText();
    String h= t6.getText();
    String i= t7.getText();
  
    if ("".equals(t1.getText()) || "".equals(t2.getText())|| "".equals(t3.getText())|| "".equals(t4.getText())|| "".equals(t5.getText())
            || "".equals(t6.getText())|| "".equals(t7.getText())|| "".equals(choicebox.getValue())) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Fill all fields ...");
            alert.setTitle("Error");
     
            alert.showAndWait();
            return;
        }
     try        
        {
            PreparedStatement pst;

            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Mamtavinod40*");
             
            Statement s1 = con.createStatement();
             String s2 = "insert into room_book(name,age,contact,email,room_type,num,check_in,check_out) values ('"+a+"','"+c+"','"+d+"','"+e1+"','"+f+"','"+g+"','"+h+"','"+i+"');";
             
             
             System.out.println("sucess"); 
            s1.executeUpdate(s2); 
         
             }
     
        catch(Exception e)
        {System.out.println(e);} 
     t1.setText("");
            t2.setText("");
             t3.setText("");
              t4.setText("");
               t5.setText("");
                t6.setText("");
                 t7.setText("");
               choicebox.setValue("");
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
            alert.setHeaderText("Room booked successfully and BOOKING ID generated.");
            alert.setTitle("Notification");
            alert.showAndWait();}
    
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
        
            

