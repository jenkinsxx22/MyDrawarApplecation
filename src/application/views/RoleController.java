package application.views;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.Roles;
import application.services.RoleServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox; 
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.BorderPane;

public class RoleController implements Initializable{
	  @FXML
	    private BorderPane Blankborderpane;
	  @FXML
	  private TextField textId;
	  @FXML
	  private TextField textName;
	  @FXML
	  private ComboBox<String> textGroup;
	  @FXML
	  private TextField textCreatedOn;
	  @FXML
	  private TextField textCreatedBy;

	  @FXML
	  private Button btnDelete;
	  @FXML
	  private Button btnSave;
	  @FXML
	    private Button btnClose;

	  @FXML
	    private TableView<Roles> RolesTable;
	    @FXML
	    private TableColumn<Roles, String> ColumnId;
	    @FXML
	    private TableColumn<Roles, String> ColumnName;
	    @FXML
	    private TableColumn<Roles, String> ColumnGroup;

	  private MainAppController mainApp;
	  @Override
	    public void initialize(URL location, ResourceBundle resources) {
		  textGroup.getItems().add("GEN");
		  textGroup.getItems().add("REF");
		  textGroup.getItems().add("DED");
		  
		  textId.setDisable(true);
		  textCreatedOn.setDisable(true);
		  textCreatedBy.setDisable(true);

		  btnClose.setOnMouseClicked(event->{
			  mainApp.setFXML("Blank","CENTER");
		  });
		  
		  textName.setOnKeyTyped(event->{
		    	if (textName.getText().equals(null)) {
		    		textName.setBlendMode(BlendMode.SRC_OVER);
		    	}
		    	else {
		    		textName.setBlendMode(BlendMode.COLOR_BURN);
		    		}
		  });

	
	    	// Initialize the User table with the two columns.
		  ColumnId.setCellValueFactory(cellData -> cellData.getValue().getSimpleId());
		  ColumnName.setCellValueFactory(cellData -> cellData.getValue().getSimpleRoleName());
		  ColumnGroup.setCellValueFactory(cellData -> cellData.getValue().getSimpleRoleGroup());
	        
		  btnSave.setOnMouseClicked(event->{
				 RoleServices roleservice = new RoleServices();
				  Roles role = new Roles();
				  role.setRoleName(textName.getText());
				  role.setRoleGroup(textGroup.getSelectionModel().getSelectedItem().toString());

				  System.out.println("Saved!");
		  });
		  
		
	  }
	  

	    public void setMainApp(MainAppController controller)  {
	        this.mainApp = controller;
	        RolesTable.setItems(mainApp.getRolesData()); 
	    }

	     
}
