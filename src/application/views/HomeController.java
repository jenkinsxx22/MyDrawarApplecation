package application.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.BorderPane;

public class HomeController implements Initializable{
	  @FXML
	    private BorderPane Homeborderpane;
	  @FXML
	    private Button btnSearch;
	  @FXML
	    private Button btnClose;
	    @FXML
	    private TextField txtSearch;
	    @FXML
	    private ListView<String> lstHome;   
	    private ObservableList<String> homeData = FXCollections.observableArrayList(); 

	    private MainAppController mainApp;
	    
	  @Override
	    public void initialize(URL location, ResourceBundle resources) {
		  homeData.add("Create new user");
		  homeData.add("Search User");
		  homeData.add("Delete");
		  homeData.add("Settings");
		  homeData.add("Backup Data");
		  homeData.add("Roles");
		  lstHome.setItems(homeData);
		  btnClose.setOnMouseClicked(event->{
			  mainApp.setFXML("Blank","CENTER");
		  });
		  txtSearch.setOnKeyTyped(event->{
			  txtSearch.setBlendMode(BlendMode.COLOR_BURN);
		  });
		  btnSearch.setOnMouseClicked(event->{
			  SearchText(txtSearch.getText());
		  });
		  
	  
		  lstHome.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->showRoleDetails(newValue));
		   
	  }
	  
	    public void setMainApp(MainAppController controller)  {
	        this.mainApp = controller;
	    }
	    
	    public void SearchText(String txtSrch) {
	    	homeData.contains(txtSrch);
	    	//lstHome.getItems().clear();
	    	lstHome.setItems(homeData);
	    }
	    private void showRoleDetails(String itemname) {
	        if (itemname.equals("Roles")) {
	        	 mainApp.setFXML("Role","CENTER");	        
	        }
	    }
	    
	    
}
