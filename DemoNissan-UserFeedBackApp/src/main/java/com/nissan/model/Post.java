package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TblPost")
public class Post {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@Column(nullable=false)
	private String postDetail;
	private LocalDate postDate;
	private int userId;
	
	@JoinColumn(name ="userId",insertable = false,updatable=false)	 
	@ManyToOne					 	
	private User user;

	//Default
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized
	public Post(int postId, String postDetail, User user,LocalDate postDate) {
		super();
		this.postId = postId;
		this.postDetail = postDetail;
		this.user = user;
		this.postDate = postDate;
	}

	//Getters and Setters
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostDetail() {
		return postDetail;
	}

	public void setPostDetail(String postDetail) {
		this.postDetail = postDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	//override toString
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postDetail=" + postDetail + ", postDate=" + postDate + ", userId=" + userId
				+ ", user=" + user + "]";
	}

	
	
	
	
}
