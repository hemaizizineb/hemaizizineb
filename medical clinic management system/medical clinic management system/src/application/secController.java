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

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class secController implements Initializable {
	   @FXML
	    private AnchorPane Dashboard_TR;

	    @FXML
	    private AnchorPane Dashboard_form;

	    @FXML
	    private AnchorPane Dashboard_pA;

	    @FXML
	    private AnchorPane Dashboard_tP;

	    @FXML
	    private Label TOTAL_RDV;

	    @FXML
	    private Label TOTAL_RDV2;

	    @FXML
	    private Label TOTAL_pat;

	    @FXML
	    private Button accueil;

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
	    private Label date_time;

	    @FXML
	    private Button delete_btn;

	    @FXML
	    private Button delete_btn_pat;

	    @FXML
	    private Button edit_btn;

	    @FXML
	    private Button edit_btn_pat;

	    @FXML
	    private Button exit_btn;

	    @FXML
	    private TextField pat_search;

	    @FXML
	    private Button patient;

	    @FXML
	    private Label user;
@FXML
	    private TableColumn<Patient, Integer> poids_pat_col;
	    @FXML
	    private TableColumn<Patient, String> sexe_pat_col;

	    @FXML
	    private AnchorPane patient_form;
	    @FXML
	    private TableColumn<Patient, Integer>taille_pat_col;
	    @FXML
	    private TableColumn<Patient, Integer>  patient_col_IDpat;

	    @FXML
	    private TableColumn<Patient, String>  patient_col_NOMpat;

	    @FXML
	    private TableColumn<Patient, String>patient_col_Prenompat;

	    @FXML
	    private TableColumn<Patient, String> patient_col_dat;

	    @FXML
	    private TableColumn<Patient, Integer>  patient_col_numtlph;
	    
	    @FXML
	    private TableView<Patient> patient_tableView;
    @FXML
    private TableColumn<RDV, String> rdv_col_dateRDV;

    @FXML
    private TableColumn<RDV, String> rdv_col_heure;

    @FXML
    private TableColumn<RDV, String> rdv_col_heureFIN;

    @FXML
    private TableColumn<RDV, Integer> rdv_col_id;

    @FXML
    private TableColumn<Patient, Integer> rdv_col_idPat;

    @FXML
    private TableColumn<RDV, Statut> rdv_col_statut;

    @FXML
    private TableView<RDV> RDV_tableView;
    @FXML
    private TextField addId_patient1;

    @FXML
    private ComboBox<?> addchoice_patient1;
    @FXML
    private ComboBox<?> addchoice_patient11;


    @FXML
    private TextField adddate_patient1;


    @FXML
    private TextField addnom_patient1;

    @FXML
    private TextField addpoids_patient1;

    @FXML
    private TextField addtaille_patient1;
    @FXML
    private Button rdv_btn;@FXML
    private Button logout;
    @FXML
    private AnchorPane rdv_form;
    
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
            patient.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                    + "#7AD0FC, #00579A");
          rdv_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                   + "#7AD0FC, #00579A");
           
        });
        
       

        
      
     rdv_btn.setOnMouseEntered((MouseEvent event) ->{
          
    	 rdv_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	                + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
	                + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
	                + "-fx-border-width:0px 0px 0px 5px");
     	  patient.setStyle("-fx-background-color:linear-gradient(to bottom right,"
                  + "#7AD0FC, #00579A"); 
     	 accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
     	           + "#7AD0FC, #00579A");
     	    });

      patient.setOnMouseEntered((MouseEvent event) ->{
          
    	  patient.setStyle("-fx-background-color:linear-gradient(to bottom right,"
	                + " rgba(121, 172, 255, 0.6), rgba(255, 106, 239, 0.6));"
	                + "-fx-border-color:linear-gradient(to bottom, #517ab5, #ae44a5);"
	                + "-fx-border-width:0px 0px 0px 5px");
          
    	  accueil.setStyle("-fx-background-color:linear-gradient(to bottom right,"
    	           + "#7AD0FC, #00579A");
    	    

    	      rdv_btn.setStyle("-fx-background-color:linear-gradient(to bottom right,"
    	              + "#7AD0FC, #00579A");

    	     });
  
       
        
 
}
public void exit(){
    
    System.exit(0);
    
}

    public void switchForm(ActionEvent event) {

        if (event.getSource() == accueil) {
            Dashboard_form.setVisible(true);
            patient_form.setVisible(false);
            rdv_form.setVisible(false);
       	TOTALRDV();EnAtt();TotalPatient();

        } else if (event.getSource() == patient) {
          Dashboard_form.setVisible(false);
        patient_form.setVisible(true);
       rdv_form.setVisible(false);
      
       PatientSexeList();
       patSearch();
       }else if (event.getSource() == rdv_btn) 
        { Dashboard_form.setVisible(false);
        patient_form.setVisible(false);
       rdv_form.setVisible(true);
    
        }
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


    public ObservableList<Patient> PatientListData() {

        ObservableList<Patient> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM patient ";

        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            Patient patientD;

            while (result.next()) {
                patientD = new Patient(
                		result.getInt("id"),
                        result.getInt("poid"),
                    	result.getInt("taille"),
                        result.getInt("num_tel"),
                		result.getString("nom"),
                		result.getString("prenom"),
                		result.getString("sexe"),
                		result.getString("adress"),
                        result.getString("bd"));
                listData.add(patientD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }


        	
    public void PatientSelect() {
        Patient patientD = patient_tableView.getSelectionModel().getSelectedItem();
        int num = patient_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

       addId_patient.setText(String.valueOf(patientD.getId()));
       addnum_patient.setText(String.valueOf(patientD.getNum_tel()));
       addtaille_patient.setText(String.valueOf(patientD.getTaille()));
       adddate_patient.setText(patientD.getBd());
       addpoids_patient.setText(String.valueOf(patientD.getPoid()));
       addaddress_patient.setText(patientD.getAdress());
       addprenom_patient.setText(patientD.getPrenom());
       addnom_patient.setText(patientD.getNom());


    }
    private String[] listSexe = {"Male", "Female"};

    public void PatientSexeList() {
        List<String> listS = new ArrayList<>();

        for (String data : listSexe) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        addchoice_patient.setItems(listData);
    }


    public void PatientAdd() {

     
        String sql = "INSERT INTO patient "
                + "(id 	,nom, 	prenom ,	adress  ,	num_tel ,	bd ,	poid ,	taille ,	sexe 	) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (addId_patient.getText().isEmpty()
                    || addnom_patient.getText().isEmpty()
                    || addprenom_patient.getText().isEmpty()
                    || addchoice_patient.getSelectionModel().getSelectedItem() == null
                    || addnum_patient.getText().isEmpty()
                    || addtaille_patient.getText().isEmpty()
                    || addpoids_patient.getText().isEmpty()
                    || adddate_patient.getText().isEmpty()
                    || addaddress_patient.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("VEUILLEZ ENTRER TOUS LES INFO SVP !");
                alert.showAndWait();
            } else {

                String check = "SELECT id FROM patient WHERE id = '"
                        + addId_patient.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Patient ID: " + addId_patient.getText() + " existe Déja!!");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addId_patient.getText());
                    prepare.setString(2,addnom_patient.getText());
                    prepare.setString(3, addprenom_patient.getText());
                    prepare.setString(4, addaddress_patient.getText()); 
                    prepare.setString(5, addnum_patient.getText());
                    prepare.setString(9, (String) addchoice_patient.getSelectionModel().getSelectedItem());
                    prepare.setString(8, addtaille_patient.getText());
                    prepare.setString(7,addpoids_patient.getText());
                    prepare.setString(6, adddate_patient.getText());
                    prepare.executeUpdate();

                    String insertInfo = "INSERT INTO patient "
                    		  + "(id 	,nom, 	prenom ,	adress  ,	num_tel ,	bd ,	poid ,	taille ,	sexe 	) "
                              + "VALUES(?,?,?,?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertInfo);
                    prepare.setString(1, addId_patient.getText());
                    prepare.setString(2,addnom_patient.getText());
                    prepare.setString(3, addprenom_patient.getText());
                    prepare.setString(4, addaddress_patient.getText()); 
                    prepare.setString(5, addnum_patient.getText());
                    prepare.setString(9, (String) addchoice_patient.getSelectionModel().getSelectedItem());
                    prepare.setString(8, addtaille_patient.getText());
                    prepare.setString(7,addpoids_patient.getText());
                    prepare.setString(6, adddate_patient.getText());             
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Ajouté !");
                    alert.showAndWait();
                    PatientShowListData();
                    Patientsupp();
                  
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private ObservableList<Patient> PatientList;
    private void PatientShowListData() {
    	PatientList = PatientListData();

    	patient_col_IDpat.setCellValueFactory(new PropertyValueFactory<>("id"));
    	patient_col_NOMpat.setCellValueFactory(new PropertyValueFactory<>("nom"));
    	patient_col_Prenompat.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    	address_pat_col.setCellValueFactory(new PropertyValueFactory<>("adress"));
    	patient_col_numtlph.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
    	patient_col_dat.setCellValueFactory(new PropertyValueFactory<>("bd"));
    	poids_pat_col.setCellValueFactory(new PropertyValueFactory<>("poid"));
    	taille_pat_col.setCellValueFactory(new PropertyValueFactory<>("taille"));
    	sexe_pat_col.setCellValueFactory(new PropertyValueFactory<>("sexe"));

        patient_tableView.setItems(PatientList);
    	
    	
    }
    public void Patientsupp() {
    	 addId_patient.setText(" ");
    	 addnom_patient.setText(" ");
         addprenom_patient.setText(" "); 
         addaddress_patient.setText(" ");
         addnum_patient.setText(" ");
         adddate_patient.setText(" "); 
         addpoids_patient.setText(" ");
        addtaille_patient.setText(" ");
             addchoice_patient.getSelectionModel().clearSelection();

    }



    public void PatientDelete() {

        String sql = "DELETE FROM patient WHERE id = '"
                + addId_patient.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (addId_patient.getText().isEmpty()
                    ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("ENTRER LE ID SVP!!");
                alert.showAndWait();
            } else {
               
                
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    String deleteInfo = "DELETE FROM patient WHERE id = '"
                            + addId_patient.getText() + "'";

                    prepare = connect.prepareStatement(deleteInfo);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Supprimé!");
                    alert.showAndWait();

                   PatientShowListData();
                   Patientsupp();
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void PatientEdite() {

       
        String sql = "UPDATE patient SET nom = '"
                + addnom_patient.getText() + 
                "', prenom = '"
                + addprenom_patient.getText() + 
                "', adress = '"
                + addaddress_patient.getText() + 
                "', num_tel = '"
                + addnum_patient.getText() +
                "', bd = '"
                + adddate_patient.getText() 
               + "', poid = '"
                + addpoids_patient.getText() +
                "', taille = '"
                + addtaille_patient.getText() +
                "', sexe = '"
                + addchoice_patient.getSelectionModel().getSelectedItem()  
                + "' WHERE id ='"
                + addId_patient.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (addId_patient.getText().isEmpty()
                    || addnom_patient.getText().isEmpty()
                    || addprenom_patient.getText().isEmpty()
                    || addchoice_patient.getSelectionModel().getSelectedItem() == null
                    || addnum_patient.getText().isEmpty()
                    || addtaille_patient.getText().isEmpty()
                    || addpoids_patient.getText().isEmpty()
                    || adddate_patient.getText().isEmpty()
                    || addaddress_patient.getText().isEmpty()) {
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

                    PatientShowListData();
                      Patientsupp();  
    }

            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    public void patSearch() {

        FilteredList<Patient> filter = new FilteredList<>(PatientList, e -> true);

        pat_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicatePatient -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();


                if (String.valueOf(predicatePatient.getId()).toString().contains(searchKey)) {
                    return true;
                } else if (predicatePatient.getNom().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatePatient.getPrenom().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatePatient.getAdress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicatePatient.getNum_tel()).toString().contains(searchKey)) {
                    return true;
                } else if (predicatePatient.getBd().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicatePatient.getPoid()).toString().contains(searchKey)) {
                    return true;
                } else if (String.valueOf(predicatePatient.getTaille()).toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Patient> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(patient_tableView.comparatorProperty());
        patient_tableView.setItems(sortList);
    }


    public ObservableList<RDV> RDVListData() {

        ObservableList<RDV> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM rdvtab ";

        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            RDV rdvD;

            while (result.next()) {
                rdvD = new RDV(
                		result.getInt("id"),
                        result.getInt("id_pat"),
                    	result.getString("date"),
                        result.getString("heure"),
                		result.getString("heure_fin"),
                		result.getString("statut")
                		);
                listData.add(rdvD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }


        	
    public void RDVSelect() {
        RDV rdvD = RDV_tableView.getSelectionModel().getSelectedItem();
        int num = RDV_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1)< -1)
            {return;}
        

        addId_patient1.setText(String.valueOf(rdvD.getId()));
        addnom_patient1.setText(String.valueOf(rdvD.getId_pat()));
        adddate_patient1.setText(rdvD.getDate());
        addpoids_patient1.setText(rdvD.getHeure());
        addtaille_patient1.setText(rdvD.getHeure_fin());
       



    }
    private String[] listStatut = {"Annulé", "Confirmé","En-attente"};

    public void RDVStatutList() {
        List<String> listS = new ArrayList<>();

        for (String data : listStatut) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        addchoice_patient1.setItems(listData);
    }

    public void RDVAdd() {

     
        String sql = "INSERT INTO rdvtab "
                + "( 	id 	,id_pat 	,	date,	heure ,	heure_fin ,statut 	) "
                + "VALUES(?,?,?,?,?,?)";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (addId_patient1.getText().isEmpty()
                    ||  addnom_patient1.getText().isEmpty()
                    ||  addchoice_patient1.getSelectionModel().getSelectedItem() == null
                    ||addtaille_patient1.getText().isEmpty()
                    ||addpoids_patient1.getText().isEmpty()
                    ||  adddate_patient1.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("VEUILLEZ ENTRER TOUS LES INFO SVP !");
                alert.showAndWait();
            } else {

                String check = "SELECT id FROM rdvtab WHERE id = '"
                        + addId_patient1.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("RDV ID: " + addId_patient1.getText() + " existe Déja!!");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addId_patient1.getText());
                    prepare.setString(2, addnom_patient1.getText());
                    prepare.setString(3, (String)  addchoice_patient1.getSelectionModel().getSelectedItem());
                    prepare.setString(5,addtaille_patient1.getText());
                    prepare.setString(4, addpoids_patient1.getText());
                    prepare.setString(6,  adddate_patient1.getText());
                    
                    prepare.executeUpdate();

                    String insertInfo = "INSERT INTO rdvtab "
                    		  + "( 	id 	,id_pat ,	date	,	heure ,	heure_fin ,statut 	) "
                              + "VALUES(?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addId_patient1.getText());
                    prepare.setString(2, addnom_patient1.getText());
                    prepare.setString(3, (String)  addchoice_patient1.getSelectionModel().getSelectedItem());
                    prepare.setString(5,addtaille_patient1.getText());
                    prepare.setString(4, addpoids_patient1.getText());
                    prepare.setString(6,  adddate_patient1.getText());
                     
                    prepare.executeUpdate();
                    
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Ajouté!");
                    prepare.executeUpdate();
                    alert.showAndWait();
                    RDVShowListData();
                    RDVsupp();
                  
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private ObservableList<RDV> RDVList;

    private void RDVShowListData() {
    	RDVList = RDVListData();

    	rdv_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	rdv_col_idPat.setCellValueFactory(new PropertyValueFactory<>("id_pat"));
    	rdv_col_dateRDV.setCellValueFactory(new PropertyValueFactory<>("date"));
    	rdv_col_heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
    	rdv_col_heureFIN.setCellValueFactory(new PropertyValueFactory<>("heure_fin"));
    	rdv_col_statut.setCellValueFactory(new PropertyValueFactory<>("statut"));

        RDV_tableView.setItems(RDVList);
    	
    	
    }
    public void RDVsupp() {
    	 addId_patient1.setText(" ");
    	  addnom_patient1.setText(" ");
          adddate_patient1.setText(" "); 
        addpoids_patient1.setText(" ");
       addtaille_patient1.setText(" ");
        addchoice_patient1.getSelectionModel().clearSelection();

    }



    public void rdvDelete() {

        String sql = "DELETE FROM rdvtab WHERE id = '"
                + addId_patient1.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (addId_patient1.getText().isEmpty()
                    ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("ENTRER LE ID SVP!!");
                alert.showAndWait();
            } else {
               
                
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    String deleteInfo = "DELETE FROM rdvtab WHERE id = '"
                            + addId_patient1.getText() + "'";

                    prepare = connect.prepareStatement(deleteInfo);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Supprimé!");
                    alert.showAndWait();

                   RDVShowListData();
                   RDVsupp();
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void RDVEdite() {

       
        String sql = "UPDATE rdvtab SET  id_pat = '"
                +  addnom_patient1.getText() + 
                "', statut = '"
                +  adddate_patient1.getText() 
               + "', heure = '"
                +addpoids_patient1.getText() +
                "', heure_fin = '"
                +addtaille_patient1.getText() +
                "', date = '"
                +  addchoice_patient1.getSelectionModel().getSelectedItem()  
                + "' WHERE id ='"
                + addId_patient1.getText() + "'";

        connect = Database.connectDb();

        try {
            Alert alert;
            if (addId_patient1.getText().isEmpty()
                    ||  addnom_patient1.getText().isEmpty()
                    ||  addchoice_patient1.getSelectionModel().getSelectedItem() == null
                    ||addtaille_patient1.getText().isEmpty()
                    ||addpoids_patient1.getText().isEmpty()
                    ||  adddate_patient1.getText().isEmpty()) {
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

                    RDVShowListData();
                      RDVsupp();  
    }

            

        } catch (Exception e) {
            e.printStackTrace();
        }

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
    	PatientShowListData();
    	PatientSexeList();
    	TOTALRDV();EnAtt();
    	TotalPatient();
        patSearch();
    	RDVShowListData();
    	RDVStatutList();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
