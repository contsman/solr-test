package brent.solrtest.beans;

import org.apache.solr.client.solrj.beans.Field;

public class Person {
	@Field
	 private int id;
	@Field
	 private String name;
	@Field
	 private String cat;
	 private float price;
	 
	 
	 public Person() {}
	public Person(int id, String name, String cat, float price) {
		super();
		this.id = id;
		this.name = name;
		this.cat = cat;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public float getPrice() {
		return price;
	}
	@Field
	public void setPrice(float price) {
		this.price = price;
	}
}
