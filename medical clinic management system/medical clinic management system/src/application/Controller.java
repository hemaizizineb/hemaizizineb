package application;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

	 @FXML
	    private AnchorPane MED_FORM;

	    @FXML
	    private Button exit_btn;

	    @FXML
	    private Button exit_btn1;

	    @FXML
	    private Button login_btn;

	    @FXML
	    private Button login_btn1;

	    @FXML
	    private Button med;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private PasswordField password1;

	    @FXML
	    private Button sec;

	    @FXML
	    private AnchorPane sec_FORM;

	    @FXML
	    private TextField username;

	    @FXML
	    private TextField username1;

    //FOR DATA BASE 
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
public void exit(){
        
        System.exit(0);
        
    }
    
    public void textfieldDesign(){
        
        if(username.isFocused()){
            
            username.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            
            password.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-width:1px");
            
        }else if(password.isFocused()){
            
            username.setStyle("-fx-background-color:transparent;"
                    + "-f-border-width:1px");
            
            password.setStyle("-fx-background-color:#fff;"
                    + "-fx-border-width:2px");
            
        }
        
    }
public void login1(){
        
        connect = Database.connectDb();
      
        try {
        	  
            String sql = "SELECT * FROM account2 WHERE username = ? and password = ?";
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username1.getText());
            prepare.setString(2, password1.getText());
            
            result = prepare.executeQuery();
            
if(result.next()){
                
	           User.username= result.getString("username");
                
                Alert alert = new Alert(AlertType.INFORMATION);
                
                alert.setTitle(" Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Login!");
                alert.showAndWait();
                
                login_btn1.getScene().getWindow().hide();
                
                Parent root = FXMLLoader.load(getClass().getResource("secDashboard.fxml"));
                
                Scene scene = new Scene(root);

                Stage stage = new Stage(); 
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                
            }else{
                
                Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Username/Password!");
                alert.showAndWait();
                
            }
            
        }catch(Exception e){}
        
}public void login(){
    
    connect = Database.connectDb();
  
    try {
    	  
        String sql = "SELECT * FROM account WHERE username = ? and password = ?";
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, username.getText());
        prepare.setString(2, password.getText());
        
        result = prepare.executeQuery();
        
if(result.next()){
            
           User.username= result.getString("username");
            
            Alert alert = new Alert(AlertType.INFORMATION);
            
            alert.setTitle(" Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Login!");
            alert.showAndWait();
            
            login_btn.getScene().getWindow().hide();
            
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            
            Scene scene = new Scene(root);

            Stage stage = new Stage(); 
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            
        }else{
            
            Alert alert = new Alert(AlertType.ERROR);
            
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Username/Password!");
            alert.showAndWait();
            
        }
        
    }catch(Exception e){}
    
}
public void switchlog(ActionEvent event) {
    if (event.getSource() == sec) {
      sec_FORM.setVisible(true);
       MED_FORM.setVisible(false);
   }else if (event.getSource() == med) 
 { sec_FORM.setVisible(false);
MED_FORM.setVisible(true);
 }
}
}
