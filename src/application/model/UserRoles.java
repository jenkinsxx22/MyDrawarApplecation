package application.model;

import javax.persistence.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Table;

import application.services.RoleServices;
import javafx.beans.property.SimpleStringProperty;

@Entity
@Table(name="user_roles")
public class UserRoles {

	@Column(name = "role_id")
	private int RoleId;
	@Column(name = "user_id")
	private int UserId;
	@Column(name = "access_type")
	private String AccessType;
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
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getAccessType() {
		return AccessType;
	}
	public void setAccessType(String accessType) {
		AccessType = accessType;
	}
	public String getRoleName() {
		
		return getRoleName(this.RoleId);
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	private String UserName;
	
	public SimpleStringProperty getSimpleAccessType() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(String.valueOf(this.AccessType));
		return simple_str;
	}
	public SimpleStringProperty getSimpleAccessRoleName() {
		SimpleStringProperty simple_str =new SimpleStringProperty();
		simple_str.set(getRoleName(this.RoleId));
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
	public String getRoleName(int roleid) {
		String rolename;
		Roles role = new Roles();
		RoleServices roleservice = new RoleServices();
		role = roleservice.GetById(roleid);
		rolename = role.getRoleName();
		return rolename;
	}
}
