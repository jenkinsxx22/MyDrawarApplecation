package application.views;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class StatusController implements Initializable{
	  @FXML
	    private BorderPane Blankborderpane;
	    private MainAppController mainApp;
	  @Override
	    public void initialize(URL location, ResourceBundle resources) {
		  
	  }
	  

	    public void setMainApp(MainAppController controller)  {
	        this.mainApp = controller;
	    }
	    
}
