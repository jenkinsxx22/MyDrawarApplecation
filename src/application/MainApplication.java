package application;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import application.beans.LoginBean;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApplication extends Application{
	   double x,y = 0;
	   



	private double mainX,mainY;
	    @Override
	    public void start(Stage primaryStage) throws Exception{
	 
	    	if(CheckLoginBean().getUserName()==null) {
	    		Parent root = FXMLLoader.load(getClass().getResource("views/Login.fxml"));
		        primaryStage.initStyle(StageStyle.UNDECORATED);
		        primaryStage.setScene(new Scene(root, 600, 400));
		        primaryStage.show();
	    	}
	    	else {
	    		Parent root = FXMLLoader.load(getClass().getResource("views/Dashboard.fxml"));	    		
		        primaryStage.initStyle(StageStyle.UNDECORATED);
		        primaryStage.setScene(new Scene(root, 800, 500));
		        primaryStage.show();
	    	}
//    		Parent root = FXMLLoader.load(getClass().getResource("views/Splash.fxml"));	    		
//	        primaryStage.initStyle(StageStyle.UNDECORATED);
//	        primaryStage.setScene(new Scene(root, 800, 500));
//	        primaryStage.show();
	    	
	        this.mainX=primaryStage.getX();
	        this.mainY=primaryStage.getY();
	    }
	    public MainApplication() {
	    	
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	    
		public double getMainX() {
			return mainX;
		}
		public double getMainY() {
			return mainY;
		}
		
		public LoginBean CheckLoginBean() throws JAXBException{
			 File loginfile = new File("logindetails.xml");
			JAXBContext logContext = JAXBContext.newInstance(LoginBean.class);
			LoginBean logBean = new LoginBean();
			Unmarshaller logUnmarshall = logContext.createUnmarshaller();
			logBean=(LoginBean) logUnmarshall.unmarshal(loginfile);

			return logBean;
				
		}
}
