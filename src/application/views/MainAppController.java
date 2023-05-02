package application.views;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import application.MainApplication;
import application.beans.LoginBean;
import application.model.Roles;
import application.model.User;
import application.services.RoleServices;
import application.services.UserServices;

public class MainAppController implements Initializable {

    @FXML
    private AnchorPane pane1,pane2;
    @FXML
    private BorderPane Homeborderpane;
    @FXML
    private HBox topBar;
    

    

    @FXML
    private ImageView exit;
    @FXML
    private ImageView Home;
    @FXML
    private ImageView data;
    @FXML
    private ImageView Add;
    @FXML
    private ImageView setting;
    @FXML
    private ImageView user;
    
    private MainApplication mainApp;
    private ObservableList<User> UserData = FXCollections.observableArrayList();

    public MainAppController(){
    	
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {   

//    	exit.setX(mainApp.getMainX());
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        Home.setOnMouseMoved(event->{
        	Home.setBlendMode(BlendMode.SRC_OVER);
        	user.setBlendMode(BlendMode.COLOR_BURN);
        	Add.setBlendMode(BlendMode.COLOR_BURN);
        	data.setBlendMode(BlendMode.COLOR_BURN);       
        	exit.setBlendMode(BlendMode.SRC_OVER);
        });
        user.setOnMouseMoved(event->{
        	user.setBlendMode(BlendMode.SRC_OVER);
        	Home.setBlendMode(BlendMode.COLOR_BURN);
        	Add.setBlendMode(BlendMode.COLOR_BURN);
        	data.setBlendMode(BlendMode.COLOR_BURN);
        	exit.setBlendMode(BlendMode.SRC_OVER);

        });
        Add.setOnMouseMoved(event->{
        	Add.setBlendMode(BlendMode.SRC_OVER);
        	Home.setBlendMode(BlendMode.COLOR_BURN);
        	user.setBlendMode(BlendMode.COLOR_BURN);
        	data.setBlendMode(BlendMode.COLOR_BURN);   
        	exit.setBlendMode(BlendMode.SRC_OVER);

        });
        data.setOnMouseMoved(event->{
        	data.setBlendMode(BlendMode.SRC_OVER);
        	Add.setBlendMode(BlendMode.COLOR_BURN);
        	Home.setBlendMode(BlendMode.COLOR_BURN);
        	user.setBlendMode(BlendMode.COLOR_BURN);
        	exit.setBlendMode(BlendMode.SRC_OVER);

        	
        });
                
        exit.setOnMouseMoved(event->{
        	data.setBlendMode(BlendMode.COLOR_BURN);
        	Add.setBlendMode(BlendMode.COLOR_BURN);
        	Home.setBlendMode(BlendMode.COLOR_BURN);
        	user.setBlendMode(BlendMode.COLOR_BURN);
        	exit.setBlendMode(BlendMode.ADD);
        	
        });
        Homeborderpane.getCenter().setOnMouseMoved(event->{
        	data.setBlendMode(BlendMode.COLOR_BURN);
        	Add.setBlendMode(BlendMode.COLOR_BURN);
        	Home.setBlendMode(BlendMode.COLOR_BURN);
        	user.setBlendMode(BlendMode.COLOR_BURN);
        	exit.setBlendMode(BlendMode.SRC_OVER);
        	
        });
        
        Home.setOnMouseClicked(event->{
        	setFXML("Home","CENTER");
        });
        user.setOnMouseClicked(event->{
        	Home.setVisible(false);

            setFXML("User","CENTER");

        });

        data.setOnMouseClicked(event->{
   		 File loginfile = new File("logindetails.xml");
   			JAXBContext logContext;
			try {
				logContext = JAXBContext.newInstance(LoginBean.class);
	   			Marshaller logMarshall = logContext.createMarshaller();
	   			LoginBean logBean = new LoginBean();
	   			logMarshall.marshal(logBean, loginfile);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setFXML("Login","CENTER");
        });

    }
    public void setMainApp(MainApplication mainApp)  {
        this.mainApp = mainApp;
        getUserData();
        getRolesData();
    }
    public void setFXML(String fxmlname, String LocationFXML) {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("views/"+fxmlname+".fxml"));

            try {
            		Homeborderpane.setCenter(loader.load());
 
				if (fxmlname=="Home") {
	            // Give the controller access to the main app.
				HomeController controller = loader.getController();
	            controller.setMainApp(this);
				}
				if (fxmlname=="User") {
		            // Give the controller access to the main app.
					UserController controller = loader.getController();
		            controller.setMainApp(this);
					}
				if (fxmlname=="Role") {
		            // Give the controller access to the main app.
					RoleController controller = loader.getController();
		            controller.setMainApp(this);
					}
				if (fxmlname=="Blank") {
		            // Give the controller access to the main app.
					BlankController controller = loader.getController();
		            controller.setMainApp(this);
					}
				if (fxmlname=="RecentChanges") {
		            // Give the controller access to the main app.
					RecentChangesController controller = loader.getController();
		            controller.setMainApp(this);
					}
				if (fxmlname=="Search") {
		            // Give the controller access to the main app.
					SearchController controller = loader.getController();
		            controller.setMainApp(this);
					}
				if (fxmlname=="Status") {
		            // Give the controller access to the main app.
					StatusController controller = loader.getController();
		            controller.setMainApp(this);
					}

            } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
    }
    public ObservableList<User> getUserData()  {
    	ObservableList<User> list = FXCollections.observableArrayList();
    	List<User> userList = new ArrayList<User>();
    	UserServices userservice = new UserServices();
    	userList=userservice.GetAll();
    	userList.forEach(u->list.add(u));
    	list.forEach(u->System.out.println("User:"+u.getFullName()));
    	
	return list;
   }
    public ObservableList<Roles> getRolesData()  {
    	ObservableList<Roles> list = FXCollections.observableArrayList();
    	List<Roles> userList = new ArrayList<Roles>();
    	RoleServices Rolesservice = new RoleServices();
    	userList=Rolesservice.GetAll();
    	userList.forEach(u->list.add(u));
    	list.forEach(u->System.out.println("Role:"+u.getRoleName()));
    	
	return list;
   }
 
	public LoginBean GetLoginBean() throws JAXBException{
		 File loginfile = new File("logindetails.xml");
		JAXBContext logContext = JAXBContext.newInstance(LoginBean.class);
		LoginBean logBean = new LoginBean();
		Unmarshaller logUnmarshall = logContext.createUnmarshaller();
		logBean=(LoginBean) logUnmarshall.unmarshal(loginfile);

		return logBean;
			
	}
	public void SetLoginBean(String txtUserName, String txtPassword) throws JAXBException{
		 File loginfile = new File("logindetails.xml");
			JAXBContext logContext = JAXBContext.newInstance(LoginBean.class);
			Marshaller logMarshall = logContext.createMarshaller();
			LoginBean logBean = new LoginBean();
			logBean.setUserName(txtUserName);
			logBean.setPassword(txtPassword);
			logMarshall.marshal(logBean, loginfile);			
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

