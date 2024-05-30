package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.lang.String;

import javafx.application.Platform;

public class DashController implements Initializable {


    @FXML
    private AnchorPane Dashboard_TR;


    @FXML
    private AnchorPane Dashboard_pA;

    @FXML
    private AnchorPane Dashboard_tP;

    @FXML
    private Button edite_btn_fiche;
	
@FXML
private AnchorPane certificat_form;

@FXML
private TextField addnom_patientc;
@FXML
private TextField addprenom_patientc;
@FXML
private TextField addavis_docteur;
@FXML
private TextField addage_patient;
@FXML
private AnchorPane Barre_de_recherch_from;

@FXML
private TextField Barre_de_recherche;
@FXML

private AnchorPane Botton_fiche_patient;

@FXML
private AnchorPane fiche_patent_from;

@FXML
private AnchorPane tab_fiche_patent_from;

@FXML
private TableView<Fiche_Patient> tab_fiche_patent;

//LES BOUTONES POUR AJOUTRE ID NOM ...
@FXML
private TextField addFP_ID;

@FXML
private TextField addFP_NOM;

@FXML
private TextField addFP_OBSERVATION;

@FXML
private TextField addFP_PRENOM;
// LES COLENES DE TABLEAU
@FXML
private TableColumn<Fiche_Patient, Integer> Fpatient_col_ID;

@FXML
private TableColumn<Fiche_Patient, String> Fpatient_col_NOM;

@FXML
private TableColumn<Fiche_Patient, String> Fpatient_col_OBSERVATION;

@FXML
private TableColumn<Fiche_Patient, String> Fpatient_col_PRENOM;

@FXML
private Button add_btn_fiche;
@FXML
private Button delete_btn_fiche;
@FXML
private Button edit_btn_fiche;
@FXML
private AnchorPane Doss_form;
@FXML
private Button add_btn_cons;

@FXML
private Button add_btn_ord;

@FXML
private Button logout;

@FXML
private Button edit_btn_cons;

@FXML
private Button edit_btn_ord;

    @FXML
    private TextField pat_search;
    @FXML
    private Label TOTAL_pat;
    @FXML
    private Label TOTAL_RDV;
    @FXML
    private Label TOTAL_RDV2;

    @FXML
    private AnchorPane Dashboard_form;

    @FXML
    private Button accueil;

    @FXML
    private Button cert1;

    @FXML
    private TextField addId_patient;

    @FXML
    private Button add_btn;

    @FXML
    private Button add_btn_pat;

    @FXML
    private TextField addaddress_patient;

    @FXML
    private ComboBox<?> addchoice_patient;
    @FXML
    private TextField adddate_patient;

    @FXML
    private TextField addnom_patient;

    @FXML
    private TextField addnum_patient;

    @FXML
    private TextField addpoids_patient;

    @FXML
    private TextField addprenom_patient;

    @FXML
    private TableColumn<Patient, String> address_pat_col;
    @FXML
    private TextField addtaille_patient;

    @FXML
    private Button cert;

    @FXML
    private Button consult;

    @FXML
    private Label date_time;

    @FXML
    private Button delete_btn;

    @FXML
    private Button delete_btn_pat;

    @FXML
    private Button doss;

    @FXML
    private Button edit_btn;

    @FXML
    private Button edit_btn_pat;

    @FXML
    private Button exit_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button ordo;
    @FXML
    private TextField dur_ordo;

    @FXML
    private Button delete_btn_cons;
    @FXML
    private TextField id_cons;
    @FXML
    private TextField idpat_cons;
    @FXML
    private TextField observ_cons;

    @FXML
    private TextField idpat_ordo;

    @FXML
    private TextField id_ordo;
    @FXML
    private Button delete_btn_ord;
    @FXML
    private TextField dose_ordo;
   
 
    @FXML
    private TableView<Consultation> Consultation_tableView;
  
    @FXML
    private TableColumn<Consultation, Integer> col0_cons;

    @FXML
    private TableColumn<Consultation, Integer> col1_cons;

    @FXML
    private TableColumn<Ordonnance, Integer> col1_ordo;

    @FXML
    private TableColumn<Consultation, String> col2_cons;

    @FXML
    private TableColumn<Ordonnance, String> col2_ordo;

    @FXML
    private TableColumn<Consultation, String> col3_cons;

    @FXML
    private TableColumn<Ordonnance, String> col3_ordo;

    @FXML
    private TableColumn<Ordonnance, String> col4_ordo;

    @FXML
    private TextField date_cons;

    @FXML
    private TextField medic_ordo;

    @FXML
    private Button print_btn;
  

    @FXML
    private TableView<Ordonnance>  ordonnancetableView;

    @FXML
    private Label user;

    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

	    

public void account(){
        
        user.setText(User.username+"!"); 
        
    }
public void navButton(){
	accueil.setOnMouseClicked((MouseEvent event) ->{
        
       accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
                + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
                + "-fx-border-width:0px 0px 0px 5px");
               doss.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                + "#7AD0FC, #00579A");
       cert1.setStyle("-fx-background-color:linear-gradient(to bottom right,"
               + "#7AD0FC, #00579A");
       cert.setStyle("-fx-background-color:linear-gradient(to bottom right,"
               + "#7AD0FC, #00579A");
       doss.setStyle("-fx-background-color:linear-gradient(to bottom right,"
               + "#7AD0FC, #00579A");
    });
    

 
   
 
 
  doss.setOnMouseClicked((MouseEvent event) ->{
      
 	 doss.setStyle("-fx-background-color:linear-gradient(to bottom right,"
              + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
              + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
              + "-fx-border-width:0px 0px 0px 5px");
      
 	 accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
 	           + "#7AD0FC, #00579A");
 	    
 	     cert1.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                 + "#7AD0FC, #00579A");
 	     cert.setStyle("-fx-background-color:linear-gradient(to bottom right,"
 	             + "#7AD0FC, #00579A");    });

cert.setOnMouseClicked((MouseEvent event) ->{
      
	  cert.setStyle("-fx-background-color:linear-gradient(to bottom right,"
              + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
              + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
              + "-fx-border-width:0px 0px 0px 5px");
      
	  accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	           + "#7AD0FC, #00579A");
	     
	      cert1.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	                 + "#7AD0FC, #00579A");
	      doss.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	              + "#7AD0FC, #00579A");
	         });
cert1.setOnMouseClicked((MouseEvent event) ->{
	             
	       	  cert1.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	                     + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
	                     + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
	                     + "-fx-border-width:0px 0px 0px 5px");
	             
	       	  accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	       	           + "#7AD0FC, #00579A");
	       	    
	       	      cert.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	       	                 + "#7AD0FC, #00579A");
	       	      doss.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	       	              + "#7AD0FC, #00579A");
	       	         });
}

public void navButtonhover(){
	accueil.setOnMouseEntered((MouseEvent event) ->{
        
       accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
                + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
                + "-fx-border-width:0px 0px 0px 5px");
        
     
      
        doss.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                + "#7AD0FC, #00579A");
       cert.setStyle("-fx-background-color:linear-gradient(to bottom right,"
               + "#7AD0FC, #00579A");
       cert1.setStyle("-fx-background-color:linear-gradient(to bottom right,"
               + "#7AD0FC, #00579A");
    });
    
   

    
  
  doss.setOnMouseEntered((MouseEvent event) ->{
      
 	 doss.setStyle("-fx-background-color:linear-gradient(to bottom right,"
              + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
              + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
              + "-fx-border-width:0px 0px 0px 5px");
 	  cert1.setStyle("-fx-background-color:linear-gradient(to bottom right,"
              + "#7AD0FC, #00579A"); 
 	 accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
 	           + "#7AD0FC, #00579A");
 	   
 	     cert.setStyle("-fx-background-color:linear-gradient(to bottom right,"
 	             + "#7AD0FC, #00579A");    });

  cert.setOnMouseEntered((MouseEvent event) ->{
      
	  cert.setStyle("-fx-background-color:linear-gradient(to bottom right,"
              + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
              + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
              + "-fx-border-width:0px 0px 0px 5px");
      
	  accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	           + "#7AD0FC, #00579A");
	    

	      doss.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	              + "#7AD0FC, #00579A");
	    cert1.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	                     + "#7AD0FC, #00579A");     });

  cert1.setOnMouseEntered((MouseEvent event) ->{
      
	  cert1.setStyle("-fx-background-color:linear-gradient(to bottom right,"
              + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
              + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
              + "-fx-border-width:0px 0px 0px 5px");
      
	  accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	           + "#7AD0FC, #00579A");
	  cert.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	           + "#7AD0FC, #00579A");
	    
	      doss.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	              + "#7AD0FC, #00579A");
	     });
}
public void exit(){
    
    System.exit(0);
    
}

public void switchForm(ActionEvent event) {

    if (event.getSource() == accueil) {
        Dashboard_form.setVisible(true);
       
       Doss_form.setVisible(false);
       certificat_form.setVisible(false); 
       fiche_patent_from.setVisible(false);

   	TOTALRDV();EnAtt();TotalPatient();

    }
  
   else if (event.getSource() == doss) 
   { Dashboard_form.setVisible(false);

  Doss_form.setVisible(true);
  certificat_form.setVisible(false);
  fiche_patent_from.setVisible(false);


  ;} 
   else if (event.getSource() == cert) 
   { Dashboard_form.setVisible(false);
  
  Doss_form.setVisible(false);
 certificat_form.setVisible(true);
 fiche_patent_from.setVisible(false);
 
   }else if (event.getSource() == cert1) 
 { Dashboard_form.setVisible(false);
Doss_form.setVisible(false);
certificat_form.setVisible(false);
fiche_patent_from.setVisible(true);
 ;}
    }


public void runTime() {

    new Thread() {

        public void run() {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
            while (true) {
                try {

                    Thread.sleep(1000); //  1s

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Platform.runLater(() -> {
                    date_time.setText(format.format(new Date()));
                });
            }
        }
    }.start();

}


public void TotalPatient() {
    String sql = "SELECT COUNT(id) FROM patient";

    connect = Database.connectDb();

    int countTOTAL = 0;

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        if (result.next()) {
            countTOTAL = result.getInt("COUNT(id)");
        }

        TOTAL_pat.setText(String.valueOf(countTOTAL));

    } catch (Exception e) {
        e.printStackTrace();
    }

}

public void EnAtt() {
	
    String sql = "SELECT COUNT(id) FROM rdvtab WHERE date = 'En-attente'";

    connect = Database.connectDb();

    try {
        int countRDV = 0;

        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        if (result.next()) {
            countRDV = result.getInt("COUNT(id)");
        }

       TOTAL_RDV.setText(String.valueOf(countRDV));

    } catch (Exception e) {
        e.printStackTrace();
    }

}

public void TOTALRDV() {

    String sql = "SELECT COUNT(id) FROM rdvtab WHERE date = 'Confirmé'";

    connect = Database.connectDb();

    try {
        int countC = 0;

        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        if (result.next()) {
            countC = result.getInt("COUNT(id)");
        }
        TOTAL_RDV2.setText(String.valueOf(countC));

    } catch (Exception e) {
        e.printStackTrace();
    }

}


public ObservableList<Consultation> ConsultationListData() {

ObservableList<Consultation> listData = FXCollections.observableArrayList();
String sql = "SELECT * FROM consultation ";

connect = Database.connectDb();

try {
prepare = connect.prepareStatement(sql);
result = prepare.executeQuery();
Consultation consultationD;

while (result.next()) {
    consultationD = new Consultation(    
    		result.getInt("id"),
    		result.getInt("id_pat"),
            result.getString("date"),
        	result.getString("obs"));
    listData.add(consultationD);

}

} catch (Exception e) {
e.printStackTrace();
}
return listData;
}



public void consSelect() {
Consultation consultationD = Consultation_tableView.getSelectionModel().getSelectedItem();
int num = Consultation_tableView.getSelectionModel().getSelectedIndex();

if ((num - 1) < -1) {
return;
}

id_cons.setText(String.valueOf(consultationD.getIdc()));
idpat_cons.setText(String.valueOf(consultationD.getId()));
date_cons.setText(consultationD.getDate());
observ_cons.setText(consultationD.getObservations());


}





public void ConsultationAdd() {


String sql = "INSERT INTO consultation "
    + "(id ,id_pat,date,obs	) "
    + "VALUES(?,?,?,?)";

connect = Database.connectDb();

try {
Alert alert;
if (id_cons.getText().isEmpty()
        || idpat_cons.getText().isEmpty()
        || date_cons.getText().isEmpty() || observ_cons.getText().isEmpty())
         {
    alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Message");
    alert.setHeaderText(null);
    alert.setContentText("VEUILLEZ ENTRER TOUS LES INFO SVP !");
    alert.showAndWait();
} else {

    String check = "SELECT id FROM consultation WHERE id = '"
            + id_cons.getText() + "'";

    statement = connect.createStatement();
    result = statement.executeQuery(check);

    if (result.next()) {
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Consultation id: " + id_cons.getText() + " existe Déja!!");
        alert.showAndWait();
    } else {

        prepare = connect.prepareStatement(sql);
        prepare.setString(3,date_cons.getText());
        prepare.setString(1,id_cons.getText());
        prepare.setString(4,observ_cons.getText());
        prepare.setString(2, idpat_cons.getText());  
        
        prepare.executeUpdate();

        String insertInfo = "INSERT INTO consultation "
        		  + "(id, id_pat,date, 	obs ) "
                  + "VALUES(?,?,?,?)";

        prepare = connect.prepareStatement(insertInfo);
        prepare.setString(3,date_cons.getText());
        prepare.setString(1,id_cons.getText());
        prepare.setString(4,observ_cons.getText());
        prepare.setString(2, idpat_cons.getText());  
        prepare.executeUpdate();
        
        
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Ajouté!");
        prepare.executeUpdate();
        alert.showAndWait();
        ConsultationShowListData();
        Consultationsupp();
      
    }
}

} catch (Exception e) {
e.printStackTrace();
}

}
private ObservableList<Consultation> ConsultationList;
private void ConsultationShowListData() {
ConsultationList = ConsultationListData();
col0_cons.setCellValueFactory(new PropertyValueFactory<>("id"));
col1_cons.setCellValueFactory(new PropertyValueFactory<>("id_pat"));
col2_cons.setCellValueFactory(new PropertyValueFactory<>("date"));
col3_cons.setCellValueFactory(new PropertyValueFactory<>("obs"));
Consultation_tableView.setItems(ConsultationList);


}

public void Consultationsupp() {

id_cons.setText(" ");
idpat_cons.setText(" ");
date_cons.setText(" ");
observ_cons.setText(" ");

}



public void ConsultationDelete() {

String sql = "DELETE FROM consultation WHERE id = '"
		   + id_cons.getText() + "'";

connect = Database.connectDb();

try {
Alert alert;
if (id_cons.getText().isEmpty()
        ) {
    alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Message");
    alert.setHeaderText(null);
    alert.setContentText("ENTRER LE ID SVP!!");
    alert.showAndWait();
} else {
   
    
        statement = connect.createStatement();
        statement.executeUpdate(sql);

        String deleteInfo = "DELETE FROM consultation WHERE id = '"
                + id_cons.getText() + "'";

        prepare = connect.prepareStatement(deleteInfo);
        prepare.executeUpdate();

        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Supprimé!");
        alert.showAndWait();

       ConsultationShowListData();
       Consultationsupp();
    
}

} catch (Exception e) {
e.printStackTrace();
}

}

public void ConsultationEdite() {


String sql = "UPDATE consultation SET id_pat = '"
    + idpat_cons.getText() +
    "',date= '"
    + date_cons.getText() + 
    "', obs= '"
    + observ_cons.getText()
    + "' WHERE id ='"
    + id_cons.getText() + "'";
      connect = Database.connectDb();

try {
Alert alert;
if (id_cons.getText().isEmpty()
        || idpat_cons.getText().isEmpty()
        || date_cons.getText().isEmpty() || observ_cons.getText().isEmpty())
         {
    alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Message");
    alert.setHeaderText(null);
    alert.setContentText("VIDE");
    alert.showAndWait();
} else {
   
    
        statement = connect.createStatement();
        statement.executeUpdate(sql);
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("édité !");
        alert.showAndWait();

        ConsultationShowListData();
          Consultationsupp();  
}



} catch (Exception e) {
e.printStackTrace();
}

}
   

public ObservableList<Ordonnance> ordoListData() {

    ObservableList<Ordonnance> listData = FXCollections.observableArrayList();
    String sql = "SELECT * FROM ordonnance ";

    connect = Database.connectDb();

    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
       Ordonnance ordoD;

        while (result.next()) {
           ordoD = new Ordonnance (
                    result.getInt("id_cons"),
            		result.getString("medic"),
            		result.getString("dur"),
            		result.getString("dose")
            	);
            listData.add(ordoD);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return listData;
}


    	
public void ordoSelect() {
   Ordonnance ordoD = ordonnancetableView.getSelectionModel().getSelectedItem();
    int num = ordonnancetableView.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
        return;
    }

   idpat_ordo.setText(String.valueOf(ordoD.getId()));
   medic_ordo.setText(ordoD.getMedic());
   dur_ordo.setText(ordoD.getDuree());
   dose_ordo.setText(ordoD.getDosage());


}


public void ordoAdd() {

 
    String sql = "INSERT INTO ordonnance"
    		  + "(id_cons, 	medic ,	dur  ,	dose) "
              + "VALUES(?,?,?,?)";

    connect = Database.connectDb();

    try {
        Alert alert;
        if ( idpat_ordo.getText().isEmpty()
                ||medic_ordo.getText().isEmpty()
                || dur_ordo.getText().isEmpty()
                || dose_ordo.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("VEUILLEZ ENTRER TOUS LES INFO SVP !");
            alert.showAndWait();
        } else {


                prepare = connect.prepareStatement(sql);
                prepare.setString(1, idpat_cons.getText());
                prepare.setString(2, medic_ordo.getText());
                prepare.setString(3, dur_ordo.getText()); 
                prepare.setString(4, dose_ordo.getText());
            
                prepare.executeUpdate();

                String insertInfo = "INSERT INTO ordonnance "
                		  + "(id_cons, 	medic ,	dur  ,	dose) "
                          + "VALUES(?,?,?,?)";

                prepare = connect.prepareStatement(insertInfo);
                prepare.setString(1, idpat_cons.getText());
                prepare.setString(2, medic_ordo.getText());
                prepare.setString(3, dur_ordo.getText()); 
                prepare.setString(4, dose_ordo.getText());
            
                prepare.executeUpdate();
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Ajouté !");
                alert.showAndWait();
                ordoShowListData();
               ordosupp();
              
            }
        

    } catch (Exception e) {
        e.printStackTrace();
    }

}
private ObservableList<Ordonnance> ordoList;
private void ordoShowListData() {
	ordoList = ordoListData();

	col1_ordo.setCellValueFactory(new PropertyValueFactory<>("id_cons"));
	col2_ordo.setCellValueFactory(new PropertyValueFactory<>("medic"));
	col3_ordo.setCellValueFactory(new PropertyValueFactory<>("dur"));
	col4_ordo.setCellValueFactory(new PropertyValueFactory<>("doss"));
	

   ordonnancetableView.setItems(ordoList);
	
	
}
public void ordosupp() {
	 idpat_ordo.setText(" ");
     dur_ordo.setText(" "); 
     dose_ordo.setText(" ");
     medic_ordo.setText(" ");
  
}



public void ordoDelete() {

    String sql = "DELETE FROM ordonnance WHERE id_cons = '"
            + idpat_cons.getText() + "'";

    connect = Database.connectDb();

    try {
        Alert alert;
        if (id_ordo.getText().isEmpty()
                ) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("ENTRER LE ID SVP!!");
            alert.showAndWait();
        } else {
           
            
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                String deleteInfo = "DELETE FROM ordonnance WHERE id_cons = '"
                        + idpat_cons.getText() + "'";

                prepare = connect.prepareStatement(deleteInfo);
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Supprimé!");
                alert.showAndWait();

               ordoShowListData();
               ordosupp();
            
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

}

public void OrdonnanceEdite() {

   
    String sql = "UPDATE ordonnance SET medic = '"
            + medic_ordo.getText() + 
            "', dur = '"
            + dur_ordo.getText() + 
            "', dose = '"
            + dose_ordo.getText() 
            + "' WHERE id_cons ='"
            + idpat_ordo.getText() + "'";

    connect = Database.connectDb();

    try {
        Alert alert;
        if (
                 idpat_ordo.getText().isEmpty()
                || medic_ordo.getText().isEmpty()
                || dose_ordo.getText().isEmpty()
                || dur_ordo.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("VIDE");
            alert.showAndWait();}
                else {
           
            
                statement = connect.createStatement();
                statement.executeUpdate(sql);
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("édité !");
                alert.showAndWait();

               ordoShowListData();
                  ordosupp();  
}

     

    } catch (Exception e) {
        e.printStackTrace();
    }

}



//certif_form


public void fillFields(Certificat certif) {
  addnom_patientc.setText(certif.getNomPat());
  addprenom_patientc.setText(certif.getPrenomPat());
  addavis_docteur.setText(certif.getAvisDoc());
  addage_patient.setText(Integer.toString(certif.getAge()));


}
  
//print btn
@FXML
private void handlePrintButtonAction() {
  PrinterJob printerJob = PrinterJob.createPrinterJob();
  if (printerJob != null && printerJob.showPrintDialog(certificat_form.getScene().getWindow())) {
      boolean success = printerJob.printPage(certificat_form);
      if (success) {
          printerJob.endJob();
      }
  }
}

private Certificat certif;
@FXML
private void printFilledCertificate() {
 
	// Fill the fields of the certificate form
	fillFields(certif);

  // Create a new PrinterJob
  PrinterJob printerJob = PrinterJob.createPrinterJob();

  // Check if the printerJob is not null and the user confirms the print dialog
  if (printerJob != null && printerJob.showPrintDialog(certificat_form.getScene().getWindow())) {
      // Print the content of the certificateAnchorPane
      boolean success = printerJob.printPage(certificat_form);
      
      // If printing is successful, end the print job
      if (success) {
          printerJob.endJob();
      }
  }
}


//FICHE PATIENT


public ObservableList<Fiche_Patient> Fiche_PatientListData() {

ObservableList<Fiche_Patient> listData = FXCollections.observableArrayList();
String sql = "SELECT * FROM fich_patient ";

connect = Database.connectDb();

try {
prepare = connect.prepareStatement(sql);
result = prepare.executeQuery();
Fiche_Patient FpatientD;      

while (result.next()) {
	FpatientD = new Fiche_Patient(
	result.getString("NOM"),
	result.getString("PRENOM"),
	result.getInt("ID"),    	                    
result.getString("OBSERVATION"));
listData.add(FpatientD);

}

} catch (Exception e) {
e.printStackTrace();
}
return listData;
}

public void Fiche_PatientSelect() {
Fiche_Patient FpatientD = tab_fiche_patent.getSelectionModel().getSelectedItem();
int num = tab_fiche_patent.getSelectionModel().getSelectedIndex();

if ((num - 1) < -1) {
return;
}

addFP_ID.setText(String.valueOf(FpatientD.getID()));
addFP_PRENOM.setText(FpatientD.getPRENOM());
addFP_NOM.setText(FpatientD.getNOM());
addFP_OBSERVATION.setText(FpatientD.getOBSERVATION());


}


public void Fiche_PatientAdd() {
String sql = "INSERT INTO fich_patient "
+ "(ID 	,NOM, 	PRENOM , OBSERVATION ) "
+ "VALUES(?,?,?,?)";

connect = Database.connectDb();

try {
Alert alert;
if (addFP_ID.getText().isEmpty()
|| addFP_NOM.getText().isEmpty()
|| addFP_PRENOM.getText().isEmpty()
|| addFP_OBSERVATION.getText().isEmpty())
{
alert = new Alert(AlertType.ERROR);
alert.setTitle("Error Message");
alert.setHeaderText(null);
alert.setContentText("VEUILLEZ ENTRER TOUS LES INFO SVP !");
alert.showAndWait();
} else {

String check = "SELECT ID FROM fich_patient WHERE ID = '"
+ addFP_ID.getText() + "'";

statement = connect.createStatement();
result = statement.executeQuery(check);

if (result.next()) {
alert = new Alert(AlertType.ERROR);
alert.setTitle("Error Message");
alert.setHeaderText(null);
alert.setContentText("fiche ID: " + addFP_ID.getText() + " existe Déja!!");
alert.showAndWait();
} else {

prepare = connect.prepareStatement(sql);
prepare.setString(1, addFP_ID.getText());
prepare.setString(2,addFP_NOM.getText());
prepare.setString(3, addFP_PRENOM.getText());
prepare.setString(4, addFP_OBSERVATION.getText()); 


prepare.executeUpdate();

String insertInfo = "INSERT INTO fich_patient "
		  + "(ID 	,NOM, 	PRENOM ,	OBSEVATION) "
      + "VALUES(?,?,?,?)";

prepare = connect.prepareStatement(insertInfo);
prepare.setString(1, addFP_ID.getText());
prepare.setString(2,addFP_NOM.getText());
prepare.setString(3, addFP_PRENOM.getText());
prepare.setString(4, addFP_OBSERVATION.getText()); 
         
prepare.executeUpdate();


alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Message");
alert.setHeaderText(null);
alert.setContentText("Ajouté!");
prepare.executeUpdate();
alert.showAndWait();
Fiche_PatientShowListData();
Fiche_Patientsupp();

}
}

} catch (Exception e) {
e.printStackTrace();
}

}


private ObservableList<Fiche_Patient> Fiche_PatientList;
private void Fiche_PatientShowListData() {
Fiche_PatientList = Fiche_PatientListData();

Fpatient_col_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
Fpatient_col_NOM.setCellValueFactory(new PropertyValueFactory<>("NOM"));
Fpatient_col_PRENOM.setCellValueFactory(new PropertyValueFactory<>("PRENOM"));
Fpatient_col_OBSERVATION.setCellValueFactory(new PropertyValueFactory<>("OBSERVATION"));

tab_fiche_patent.setItems(Fiche_PatientList);


}

public void Fiche_Patientsupp() {
addFP_ID.setText(" ");
addFP_NOM.setText(" ");
addFP_PRENOM.setText(" "); 
addFP_OBSERVATION.setText(" ");

}

public void Fich_PatientDelete() {

String sql = "DELETE FROM fich_patient WHERE ID = '"
+ addFP_ID.getText() + "'";

connect = Database.connectDb();

try {
Alert alert;
if (addFP_ID.getText().isEmpty()
) {
alert = new Alert(AlertType.ERROR);
alert.setTitle("Error Message");
alert.setHeaderText(null);
alert.setContentText("ENTRER LE ID SVP!!");
alert.showAndWait();
} else {


statement = connect.createStatement();
statement.executeUpdate(sql);

String deleteInfo = "DELETE FROM fich_patient WHERE ID = '"
    + addFP_ID.getText() + "'";

prepare = connect.prepareStatement(deleteInfo);
prepare.executeUpdate();

alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Message");
alert.setHeaderText(null);
alert.setContentText("Supprimé!");
alert.showAndWait();

Fiche_PatientShowListData();
Fiche_Patientsupp();

}

} catch (Exception e) {
e.printStackTrace();
}

}


public void Fiche_PatientEdite() {


String sql = "UPDATE fich_patient SET NOM = '"
+ addFP_NOM.getText() + 
"', PRENOM= '"
+ addFP_PRENOM.getText() + 
"', OBSERVATION= '"
+ addFP_OBSERVATION.getText() + 
"' WHERE ID ='"
+ addFP_ID.getText() + "'";

connect = Database.connectDb();

try {
Alert alert;
if (
addFP_NOM.getText().isEmpty()
|| addFP_PRENOM.getText().isEmpty()
|| addFP_OBSERVATION.getText().isEmpty() ){
alert = new Alert(AlertType.ERROR);
alert.setTitle("Error Message");
alert.setHeaderText(null);
alert.setContentText("VIDE");
alert.showAndWait();
} 
else {


statement = connect.createStatement();
statement.executeUpdate(sql);
alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Message");
alert.setHeaderText(null);
alert.setContentText("édité !");
alert.showAndWait();

Fiche_PatientShowListData();
Fiche_Patientsupp();  
}



} catch (Exception e) {
e.printStackTrace();
}

}


public void logout() {


    try {
        
            logout.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("LoginApp.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
     catch (Exception e) {
        e.printStackTrace();
    }

}
@Override
	public void initialize(URL url,ResourceBundle resource) {
    	runTime();
    	account();
    	navButton();
    	TOTALRDV();EnAtt();
    	TotalPatient();
    	ConsultationShowListData();
    	ordoShowListData();
    	Fiche_PatientShowListData();
       
    }
}
