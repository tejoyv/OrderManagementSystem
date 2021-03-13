package com.project.Product.dto;
import com.project.Product.entity.Product;

public class ProductDTO {
	int PRODID;
	String BRAND;
	String CATEGORY;
	String DESCRIPTION;
	String IMAGE;
	double PRICE;
	String PRODUCTNAME;
	String RATING;
	int SELLERID;
	int STOCK;
	String SUBCATEGORY;
	
	//parameterless constructor
	public ProductDTO() {
		super();
	}
		
		//parameterized constructor
	public ProductDTO(int PRODID, String BRAND, String CATEGORY, String DESCRIPTION, String IMAGE, double PRICE,
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
	
	// Converts Entity into DTO
	public static ProductDTO valueOf(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setBRAND(product.getBRAND());
		productDTO.setCATEGORY(product.getCATEGORY());
		productDTO.setDESCRIPTION(product.getDESCRIPTION());
		productDTO.setIMAGE(product.getIMAGE());
		productDTO.setPRICE(product.getPRICE());
		productDTO.setPRODID(product.getPRODID());
		productDTO.setPRODUCTNAME(product.getPRODUCTNAME());
		productDTO.setRATING(product.getRATING());
		productDTO.setSELLERID(product.getSELLERID());
		productDTO.setSTOCK(product.getSTOCK());
		productDTO.setSUBCATEGORY(product.getSUBCATEGORY());
		return productDTO;
	}
		
	//convert dto into entity
	public Product createEntity()
	{
		Product product = new Product();
		product.setBRAND(this.getBRAND());
		product.setCATEGORY(this.getCATEGORY());
		product.setDESCRIPTION(this.getDESCRIPTION());
		product.setIMAGE(this.getIMAGE());
		product.setPRICE(this.getPRICE());
		product.setPRODID(this.getPRODID());
		product.setPRODUCTNAME(this.getPRODUCTNAME());
		product.setRATING(this.getRATING());
		product.setSELLERID(this.getSELLERID());
		product.setSTOCK(this.getSTOCK());
		product.setSUBCATEGORY(this.getSUBCATEGORY());
		return product;
	}

	@Override
	public String toString() {
		return "ProductDTO [PRODID=" + PRODID + ", BRAND=" + BRAND + ", CATEGORY=" + CATEGORY + ", DESCRIPTION="
				+ DESCRIPTION + ", IMAGE=" + IMAGE + ", PRICE=" + PRICE + ", PRODUCTNAME=" + PRODUCTNAME + ", RATING="
				+ RATING + ", SELLERID=" + SELLERID + ", STOCK=" + STOCK + ", SUBCATEGORY=" + SUBCATEGORY + "]";
	}	
	
}



