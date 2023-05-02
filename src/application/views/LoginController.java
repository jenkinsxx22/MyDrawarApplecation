package application.views;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import application.beans.LoginBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable{
	  @FXML
	    private BorderPane Blankborderpane;
	  @FXML
	    private TextField txtUserName;
	  @FXML
	    private TextField txtPassword;
	  @FXML
	  private Button btnOK;
	  @FXML
	  private Button btnCancel;
	  
	  
	  @Override
	    public void initialize(URL location, ResourceBundle resources) {
		  btnCancel.setOnMouseClicked(event->{
			   System.exit(0);
		  });
		  btnOK.setOnMouseClicked(event->{
			  File loginfile = new File("logindetails.xml");
			  try {
				JAXBContext logContext = JAXBContext.newInstance(LoginBean.class);
				Marshaller logMarshall = logContext.createMarshaller();
				LoginBean logBean = new LoginBean();
				logBean.setUserName(txtUserName.getText());
				logBean.setPassword(txtPassword.getText());
				logMarshall.marshal(logBean, loginfile);
				
				Stage dbStage = new Stage(); 
		        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
		        dbStage.initStyle(StageStyle.UNDECORATED);
		        dbStage.setScene(new Scene(root, 800, 500));
		        dbStage.show();

			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  
		  });
	  }
	  
}
