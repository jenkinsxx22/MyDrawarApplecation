package application;

import java.util.ArrayList;
import java.util.List;

import application.model.User;
import application.services.UserServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainTest {

	public static void main(String args[]) {
	ObservableList<User> list = FXCollections.observableArrayList();
	List<User> userList = new ArrayList<User>();
	UserServices userservice = new UserServices();
	userList=userservice.GetAll();
	userList.forEach(u->System.out.println("User:"+u.getFullName()));
	
////	long count = userservice.GetCount();
//	System.out.println("Total records:"+count);
}
}
