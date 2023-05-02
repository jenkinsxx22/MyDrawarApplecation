package application.views;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import application.beans.LoginBean;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class BlankController implements Initializable{
	  @FXML
	    private BorderPane Blankborderpane;
	  @FXML
	    private Label lblHome;
	    private MainAppController mainApp;
	  @Override
	    public void initialize(URL location, ResourceBundle resources) {
		  try {		 
			  File loginfile = new File("logindetails.xml");
			JAXBContext logContext = JAXBContext.newInstance(LoginBean.class);
			LoginBean logBean = new LoginBean();
			Unmarshaller logUnmarshall = logContext.createUnmarshaller();
			logBean=(LoginBean) logUnmarshall.unmarshal(loginfile);

			lblHome.setText("Welcome! "+logBean.getUserName());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  

	    public void setMainApp(MainAppController controller)  {
	        this.mainApp = controller;
	    }
	    
}
