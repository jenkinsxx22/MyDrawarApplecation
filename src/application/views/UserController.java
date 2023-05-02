package application.views;

import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.Roles;
import application.model.User;
import application.services.UserServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;

public class UserController implements Initializable{

	  @FXML
	    private BorderPane Blankborderpane;
	  @FXML
	  private TextField textFullName;
	  @FXML
	  private TextField textEmail;
	  @FXML
	  private TextField textContact;
	  @FXML
	  private TextField textAddress;
	  @FXML
	  private TextField textPhone;
	  @FXML
	  private ComboBox<String> textDesignation;
	  @FXML
	  private TextField textUserName;
	  @FXML
	  private TextField textPassword;
	  @FXML
	  private TextField textConfirmPassword;
	  @FXML
	  private Button btnOK;
	  @FXML
	  private Button btnSave;
	  @FXML
	  private Button btnSearch;
	  @FXML
	  private Button btnEdit;
	  @FXML
	  private Button btnAdd;
	  @FXML
	    private Button btnClose;

	  @FXML
	  private ComboBox<String> comboRole;
	  @FXML
	  private ComboBox<String> comboAccess;
	  
	  	@FXML
	    private TableView<Roles> RolesTable;
	    @FXML
	    private TableColumn<Roles, String> ColumnRole;
	    @FXML
	    private TableColumn<Roles, String> ColumnAccess;
	    
	    @FXML
	    private TableView<User> UserTable;
	    @FXML
	    private TableColumn<User, String> ColumnUserName;
	    @FXML
	    private TableColumn<User, String> ColumnEmail;

	    
	    
	  private MainAppController mainApp;
	  public UserController() {
	  }
	  
	  @Override
	    public void initialize(URL location, ResourceBundle resources) {
		
		  textDesignation.getItems().add("CEO");
		  textDesignation.getItems().add("CFO");
		  textDesignation.getItems().add("DDM");
		  textDesignation.getItems().add("RFO");
 
		  btnClose.setOnMouseClicked(event->{
			  mainApp.setFXML("Blank","CENTER");
		  });
		  
		  textFullName.setOnKeyTyped(event->{
		    	if (textFullName.getText().equals(null)) {
	    			textFullName.setBlendMode(BlendMode.SRC_OVER);
		    	}
		    	else {
			    		textFullName.setBlendMode(BlendMode.COLOR_BURN);
		    		}
		  });
		  textEmail.setOnKeyTyped(event->{
		    	if (textEmail.getText().equals(null)) {
		    		textEmail.setBlendMode(BlendMode.SRC_OVER);
		    	}
		    		else {
			    		textEmail.setBlendMode(BlendMode.COLOR_BURN);
		    		}
		  });
		  textContact.setOnKeyTyped(event->{
		    	if (textContact.getText().equals(null)) {
		    		textContact.setBlendMode(BlendMode.SRC_OVER);
		    	}
		    		else {
		    			textContact.setBlendMode(BlendMode.COLOR_BURN);
		    		}
		  });
		  textAddress.setOnKeyTyped(event->{
		    	if (textAddress.getText().equals(null)) {
		    		textAddress.setBlendMode(BlendMode.SRC_OVER);
		    	}
		    		else {
		    			textAddress.setBlendMode(BlendMode.COLOR_BURN);
		    		}
		  });
		  textPhone.setOnKeyTyped(event->{
		    	if (textPhone.getText().equals(null)) {
		    		textPhone.setBlendMode(BlendMode.SRC_OVER);
		    	}
		    		else {
		    			textPhone.setBlendMode(BlendMode.COLOR_BURN);
		    		}
		  });
		  textUserName.setOnKeyTyped(event->{
		    	if (textUserName.getText().equals(null)) {
		    		textUserName.setBlendMode(BlendMode.SRC_OVER);
		    	}
		    		else {
		    			textUserName.setBlendMode(BlendMode.COLOR_BURN);
		    		}
		  });
		  textPassword.setOnKeyTyped(event->{

		    	if (textPassword.getText().equals(null)) {
		    		textPassword.setBlendMode(BlendMode.SRC_OVER);
		    	}
		    		else {
		    			textPassword.setBlendMode(BlendMode.COLOR_BURN);
		    		}
		  });
		  textConfirmPassword.setOnKeyTyped(event->{
			  
		    	if (textConfirmPassword.getText().equals(null)) {
		    		textConfirmPassword.setBlendMode(BlendMode.SRC_OVER);
		    	}
		    		else {
		    			textConfirmPassword.setBlendMode(BlendMode.COLOR_BURN);
		    		}
			  
			  if(textConfirmPassword.getText().equals(textPassword.getText())) {
				  textPassword.setStyle("-fx-background-color: rgb(187,59,45);");
				  textConfirmPassword.setStyle("-fx-background-color: rgb(187,59,45);");
			  }
			  else {
				  textPassword.setStyle("-fx-background-color:RED");
				  textConfirmPassword.setStyle("-fx-background-color:RED");
			  }
			   
		  });
	    	// Initialize the User table with the two columns.
		  ColumnRole.setCellValueFactory(cellData -> cellData.getValue().getSimpleRoleGroup());
		  ColumnAccess.setCellValueFactory(cellData -> cellData.getValue().getSimpleRoleName());
		  ColumnUserName.setCellValueFactory(userData->userData.getValue().getSimpleFullName());
		  ColumnEmail.setCellValueFactory(userData->userData.getValue().getSimpleEmail());
		  btnOK.setOnMouseClicked(event->{
			  if(textConfirmPassword.getText().equals(textPassword.getText())) {
				  UserServices userservice = new UserServices();
				  User user = new User();
				  user.setFullName(textFullName.getText());
				  user.setEmail(textEmail.getText());
				  user.setContact(textContact.getText());
				  user.setAddress(textAddress.getText());
				  user.setPhone(textPhone.getText());
				  user.setDesignation(textDesignation.getSelectionModel().getSelectedItem());
				  user.setPassword(textPassword.getText());
				  userservice.Save(user);

				  System.out.println("Saved!");
			  }
			  else {
				  System.out.println("Incorrect confirm password!");
			  }
		  });
		  UserTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> ShowUserDetails(newValue));
	  

	  }
	  

	    public void setMainApp(MainAppController controller)  {
	        this.mainApp = controller;
	        UserTable.setItems(mainApp.getUserData());
	       
	    }

	
	 
	    public void fillRoleTable() {
	    	
	    }
	    
	

	     
	    public void ShowUserDetails(User user) {
	    	if(user!=null) {
	    		 textFullName.setText(user.getFullName());
	    		 textEmail.setText(user.getEmail());
	    		 textContact.setText(user.getContact());
	    		 textAddress.setText(user.getAddress());
	    		 textPhone.setText(user.getPhone());
	    		 textDesignation.setValue(user.getDesignation());
	    		 textUserName.setText(user.getUserName());
	    		 textPassword.setText(user.getPassword());
	    	}
	    }
	
	    
}
