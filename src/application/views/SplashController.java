package application.views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import application.beans.LoginBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashController implements Initializable{
	  @FXML
	    private BorderPane Blankborderpane;
	  @FXML
	    private Label lblHome;
	  private static List<String> loadingParts;
	
	  @Override
	    public void initialize(URL location, ResourceBundle resources) {
		  loadingParts.add("Loading scenes...");
		  loadingParts.add("Loading memory database...");
		  loadingParts.add("Loading program structures");
		  loadingParts.add("Loading setup data...");
		 
		  
		  LoginBean logBean = new LoginBean();
		  try {		 
			  File loginfile = new File("logindetails.xml");
			JAXBContext logContext = JAXBContext.newInstance(LoginBean.class);
			
			Unmarshaller logUnmarshall = logContext.createUnmarshaller();
			logBean=(LoginBean) logUnmarshall.unmarshal(loginfile);
 
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  if(logBean.getUserName()==null) {
			  try {
				OpenStage("Login.fxml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  
		  }
		  else {
			  try {
				OpenStage("Dashboard.fxml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  
		  }
	  }
		public void OpenStage(String fxmlLocation) throws IOException
		{
			Stage dbStage = new Stage(); 
	        Parent root = FXMLLoader.load(getClass().getResource(fxmlLocation));
	        dbStage.initStyle(StageStyle.UNDECORATED);
	        dbStage.setScene(new Scene(root, 800, 500));
	        dbStage.show();
		}
}
