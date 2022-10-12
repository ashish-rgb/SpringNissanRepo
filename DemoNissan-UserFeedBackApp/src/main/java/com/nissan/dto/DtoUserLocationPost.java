package com.nissan.dto;

public class DtoUserLocationPost {

	//fields
	private int userId;
	private String firstName;
	private String locationName;	//Location Name
	private String postDetails;		//Post details
	
	//Default
	public DtoUserLocationPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized
	public DtoUserLocationPost(int userId, String firstName, String locationName, String postDetails) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.locationName = locationName;
		this.postDetails = postDetails;
	}

	//Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(String postDetails) {
		this.postDetails = postDetails;
	}

	//override toString
	@Override
	public String toString() {
		return "DtoUserLocationPost [userId=" + userId + ", firstName=" + firstName + ", locationName=" + locationName
				+ ", postDetails=" + postDetails + "]";
	}

	

	
	
}
