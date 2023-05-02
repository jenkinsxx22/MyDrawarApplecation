package application.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import application.services.UserServices;

import javax.persistence.Id;

import javafx.beans.property.SimpleStringProperty;

@Entity
@Table(name="roles")
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private int Id;
	@Column(name="role_name")
	private String RoleName;
	@Column(name="role_group")
	private String RoleGroup;
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
	public SimpleStringProperty getSimpleId() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.Id));
		return simple_str;
	}
	public SimpleStringProperty getSimpleRoleName() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.RoleName));
		return simple_str;
	}
	public SimpleStringProperty getSimpleRoleGroup() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.RoleGroup));
		return simple_str;
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
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public String getRoleGroup() {
		return RoleGroup;
	}
	public void setRoleGroup(String roleGroup) {
		RoleGroup = roleGroup;
	}
	
	public String getUserName(int userid) {
		String username;
		User user = new User();
		UserServices userservice = new UserServices();
		user = userservice.GetById(userid);
		username = user.getUserName();
		return username;
	}
	
}
