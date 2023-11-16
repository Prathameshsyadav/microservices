package com.lcwd.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "micro_user")
public class User {
	
	@Id
	@Column(name = "ID")
	String userId;
	@Column(name = "NAME")
	String userName;
	@Column(name = "EMAIL")
	String userEmail;
	@Column(name = "ABOUT")
	String about;
	@Transient
	List<Ratings> ratings = new ArrayList<Ratings>();
	
	public List<Ratings> getRatings() {
		return ratings;
	}
	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userId, String userName, String userEmail, String about, List<Ratings> ratings) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.about = about;
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", about=" + about
				+ "]";
	}
	
	
}
