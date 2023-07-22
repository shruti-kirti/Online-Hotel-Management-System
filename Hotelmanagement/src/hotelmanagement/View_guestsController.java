
package hotelmanagement;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class View_guestsController implements Initializable {
@FXML
private TableView<ModelTable> table;
@FXML
private TableColumn<ModelTable,String> name;
@FXML
private TableColumn<ModelTable,String> age;
@FXML
private TableColumn<ModelTable,String> contact;
@FXML
private TableColumn<ModelTable,String> email;
@FXML
private TableColumn<ModelTable,String> room_type;
@FXML
private TableColumn<ModelTable,String> num;
@FXML
private TableColumn<ModelTable,String> check_in;
@FXML
private TableColumn<ModelTable,String> check_out;
@FXML
private TableColumn<ModelTable,String> bid;

ObservableList<ModelTable> oblist= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resources) {
         try {
        Connection con=DBConnector.getConnection();
        ResultSet rs=con.createStatement().executeQuery("select * from room_book where bid in(select * from check_in where room_book.bid=check_in.bid)");
        while(rs.next()){
           
                oblist.add(new ModelTable(rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("contact"),
                        rs.getString("email"),
                        rs.getString("room_type"),
                        rs.getString("num"),
                        rs.getString("check_in"),
                        rs.getString("check_out"),rs.getString("bid")));
            } }catch (SQLException ex) {
                Logger.getLogger(View_guestsController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        
 name.setCellValueFactory(new PropertyValueFactory<>("name"));
 age.setCellValueFactory(new PropertyValueFactory<>("age"));
 contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
 email.setCellValueFactory(new PropertyValueFactory<>("email"));
 room_type.setCellValueFactory(new PropertyValueFactory<>("room_type"));
 num.setCellValueFactory(new PropertyValueFactory<>("num"));
 check_in.setCellValueFactory(new PropertyValueFactory<>("check_in"));
 check_out.setCellValueFactory(new PropertyValueFactory<>("check_out"));
 bid.setCellValueFactory(new PropertyValueFactory<>("bid"));
 
 table.setItems(oblist);
 
    }    
    
}
