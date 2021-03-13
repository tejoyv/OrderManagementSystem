package com.project.Product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int PRODID;
	@Column(nullable = false)
	String BRAND;
	@Column(nullable = false)
	String CATEGORY;
	@Column(nullable = false)
	String DESCRIPTION;
	@Column(nullable = false)
	String IMAGE;
	@Column(nullable = false)
	double PRICE;
	@Column(nullable = false)
	String PRODUCTNAME;
	@Column
	String RATING;
	@Column(nullable = false)
	int SELLERID;
	@Column(nullable = false)
	int STOCK;
	@Column(nullable = false)
	String SUBCATEGORY;
	
	//parameterless constructor
	public Product() {
		super();
	}
		
		//parameterized constructor
	public Product(int PRODID, String BRAND, String CATEGORY, String DESCRIPTION, String IMAGE, double PRICE,
				String PRODUCTNAME, String RATING, int SELLERID, int STOCK, String SUBCATEGORY) {
		super();
		this.PRODID = PRODID;
		this.BRAND = BRAND;
		this.CATEGORY = CATEGORY;
		this.DESCRIPTION = DESCRIPTION;
		this.IMAGE = IMAGE;
		this.PRICE = PRICE;
		this.PRODUCTNAME = PRODUCTNAME;
		this.RATING = RATING;
		this.SELLERID = SELLERID;
		this.STOCK = STOCK;
		this.SUBCATEGORY = SUBCATEGORY;
	}	
	
	//getters and setters 
	public int getPRODID() {
		return PRODID;
	}
	public void setPRODID(int PRODID) {
		this.PRODID = PRODID;
	}
	public String getBRAND() {
		return BRAND;
	}
	public void setBRAND(String BRAND) {
		this.BRAND = BRAND;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String CATEGORY) {
		this.CATEGORY = CATEGORY;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}
	public String getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(String IMAGE) {
		this.IMAGE = IMAGE;
	}
	public double getPRICE() {
		return PRICE;
	}
	public void setPRICE(double PRICE) {
		this.PRICE = PRICE;
	}
	public String getPRODUCTNAME() {
		return PRODUCTNAME;
	}
	public void setPRODUCTNAME(String PRODUCTNAME) {
		this.PRODUCTNAME = PRODUCTNAME;
	}
	public String getRATING() {
		return RATING;
	}
	public void setRATING(String RATING) {
		this.RATING = RATING;
	}
	public int getSELLERID() {
		return SELLERID;
	}
	public void setSELLERID(int SELLERID) {
		this.SELLERID = SELLERID;
	}
	public int getSTOCK() {
		return STOCK;
	}
	public void setSTOCK(int STOCK) {
		this.STOCK = STOCK;
	}
	public String getSUBCATEGORY() {
		return SUBCATEGORY;
	}
	public void setSUBCATEGORY(String SUBCATEGORY) {
		this.SUBCATEGORY = SUBCATEGORY;
	}
}

