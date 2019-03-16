package com.moonis.demo.restapi.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.moonis.demo.restapi.entity.AbstractEntity;

import lombok.ToString;


@Document(collection = "user")
@ToString
public class User extends AbstractEntity  {
	@Id
	private String id;
	private String fname;
	private String lname;

	
	
	private String contactnumber;

	@Indexed(unique = true)
	private String email;
	private String jobtitle;
	
	private String usertype;
	private Date lastlogin;
	private String status;
	
	@DBRef(lazy = true)
	private AppUser appuser;
	
	private boolean addonaccount;
	
	private boolean active;
	
	private boolean deleted;
	
	private boolean accountmanager;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Date getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	
	public AppUser getAppuser() {
		return appuser;
	}
	public void setAppuser(AppUser appuser) {
		this.appuser = appuser;
	}
	
	public boolean isAddonaccount() {
		return addonaccount;
	}
	public void setAddonaccount(boolean addonaccount) {
		this.addonaccount = addonaccount;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return the accountmanager
	 */
	public boolean isAccountManager() {
		return accountmanager;
	}
	/**
	 * @param accountmanager the accountmanager to set
	 */
	public void setAccountManager(boolean accountmanager) {
		this.accountmanager = accountmanager;
	}
	
	
	
	
	
	
	
	/*@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", company=" + company + ", contactnumber=" + contactnumber
				+ ", email=" + email + ", jobtitle=" + jobtitle + ", usertype=" + usertype + ", lastlogin=" + lastlogin
				+ ", status=" + status + "]";
	}*/
	
	
}

