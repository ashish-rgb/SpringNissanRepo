package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TblUser")
public class User {

		//Fields
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int userId;
		
		@Column(nullable=false,unique=true)
		private String email;
		
		@Column(nullable=false)
		private String firstName;
		private String lastName;
		private boolean isActive;
		
		private int locationId;  //fk
		
		@JoinColumn(name ="locationId",insertable=false,updatable=false)	 
		@ManyToOne					 	
		private Location location; //getter @JsonBackReference
		
		//for One User Many Posts
		//@JsonIgnore
		@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
		private List<Post> posts;		//getter @JsonManagedReference

		//Default
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		//Parameterized
		public User(int userId, String email, String firstName, String lastName, boolean isActive, Location location) {
			super();
			this.userId = userId;
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
			this.isActive = isActive;
			this.location = location;
		}

		//Getters and Setters
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		@JsonBackReference
		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		@JsonManagedReference
		public List<Post> getPosts() {
			return posts;
		}

		public void setPosts(List<Post> posts) {
			this.posts = posts;
		}
		
		public int getLocationId() {
			return locationId;
		}

		public void setLocationId(int locationId) {
			this.locationId = locationId;
		}

		//override toString
		@Override
		public String toString() {
			return "User [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", isActive=" + isActive + ", locationId=" + locationId + ", location=" + location + ", posts="
					+ posts + "]";
		}

		
		
	
		
		
}
