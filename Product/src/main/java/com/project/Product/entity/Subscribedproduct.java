package com.project.Product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.Product.dto.ProductDTO;

@Entity
@Table(name = "subscribedproduct")
public class Subscribedproduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int SUBID;
	@Column(nullable = false)
	int BUYERID;
	@Column(nullable = false)
	int PRODID;
	@Column(nullable = false)
	int QUANTITY;
	
	//constructors
	public Subscribedproduct() {
		super();
	}
	
	public Subscribedproduct(int SUBID, int BUYERID, int PRODID, int QUANTITY) {
		super();
		this.SUBID = SUBID;
		this.BUYERID = BUYERID;
		this.PRODID = PRODID;
		this.QUANTITY = QUANTITY;
	}

	//getters and setters
	public int getSUBID() {
		return SUBID;
	}

	public void setSUBID(int SUBID) {
		this.SUBID = SUBID;
	}

	public int getBUYERID() {
		return BUYERID;
	}

	public void setBUYERID(int BUYERID) {
		this.BUYERID = BUYERID;
	}

	public int getPRODID() {
		return PRODID;
	}

	public void setPRODID(int PRODID) {
		this.PRODID = PRODID;
	}

	public int getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(int QUANTITY) {
		this.QUANTITY = QUANTITY;
	}
	

}
