package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TblLocation")
public class Location {

		//Fields
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int locationId;
		private String locationName;
		
		//for One Location Many Users
		@JsonIgnore
		@OneToMany(mappedBy="location",cascade=CascadeType.ALL)
		private List<User> users;

		//Default
		public Location() {
			super();
			// TODO Auto-generated constructor stub
		}

		//Parameterized
		public Location(int locationId, String locationName) {
			super();
			this.locationId = locationId;
			this.locationName = locationName;
		}

		//Getters and Setters
		public int getLocationId() {
			return locationId;
		}

		public void setLocationId(int locationId) {
			this.locationId = locationId;
		}

		public String getLocationName() {
			return locationName;
		}

		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

		//override toString
		@Override
		public String toString() {
			return "Location [locationId=" + locationId + ", locationName=" + locationName + ", users=" + users + "]";
		}
	
		
}
