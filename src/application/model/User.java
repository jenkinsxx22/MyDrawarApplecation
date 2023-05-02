package application.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javafx.beans.property.SimpleStringProperty;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int Id;
	@Column(name="full_name")
	private String FullName;
	@Column(name="email")
	private String Email;
	@Column(name="contact")
	private String Contact;
	@Column(name="address")
	private String Address;
	@Column(name="phone")
	private String Phone;
	@Column(name="designation")
	private String Designation;	
	@Column(name="username")
	private String UserName;
	@Column(name="password")
	private String Password;
	@Column(name="created_on")
	private LocalDateTime CreatedOn;
	@Column(name="created_by")
	private int CreatedBy;
	
	
	public LocalDateTime getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		CreatedOn = createdOn;
	}
	public int getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(int createdBy) {
		CreatedBy = createdBy;
	}
	public User() {
		this(null, null);
	}
	public User(String fullname, String email) {
		this.FullName = fullname;
		this.Email =email;
		this.Contact="(123) 322212";
		this.Address="XYZ Street ABX";
	}

	
	public SimpleStringProperty getSimpleId() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.Id));
		return simple_str;
	}
	
	public SimpleStringProperty getSimpleFullName() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.FullName));
		return simple_str;
	}
	
	public SimpleStringProperty getSimpleEmail() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.Email));
		return simple_str;
	}
	
	public SimpleStringProperty getSimpleContact() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.Contact));
		return simple_str;
	}
 
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	public SimpleStringProperty getSimpleCreatedOn() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.CreatedOn));
		return simple_str;
	}
	public SimpleStringProperty getSimpleAccessCreatedBy() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.CreatedBy));
		return simple_str;
	}

	
}
