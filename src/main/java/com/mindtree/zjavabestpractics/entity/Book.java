package com.mindtree.zjavabestpractics.entity;

import java.util.List;

public class Book {
	
	 private int id;
	 private String title;
	 private int price;
	 private List<Author> authors;
	 
	 
	 
	 
	public Book() {
		super();
		
	}
	public Book(int id, String title, int price, List<Author> authors) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.authors = authors;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	 
	 
}
