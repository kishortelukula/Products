package com.product.entity;

public class AllProducts {
	private int productId;
    private String productName;
    private String productPrice;
    private String productTitle;
    private String productDescription;
    private String fileName;
    private String filePath;

    public AllProducts() {
    }
    

    public AllProducts(int productId, String productName, String productPrice, String productTitle,
			String productDescription, String fileName, String filePath) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productTitle = productTitle;
		this.productDescription = productDescription;
		this.fileName = fileName;
		this.filePath = filePath;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductTitle() {
		return productTitle;
	}


	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	@Override
	public String toString() {
		return "AllProducts [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productTitle=" + productTitle + ", productDescription=" + productDescription + ", fileName="
				+ fileName + ", filePath=" + filePath + "]";
	}
    
    
    

	/*
	 * public AllProducts(String productName, String productPrice, String
	 * productTitle, String productDescription, String fileName, String filePath) {
	 * this.productName = productName; this.productPrice = productPrice;
	 * this.productTitle = productTitle; this.productDescription =
	 * productDescription; this.fileName = fileName; this.filePath = filePath; }
	 * 
	 * public String getProductName() { return productName; }
	 * 
	 * public void setProductName(String productName) { this.productName =
	 * productName; }
	 * 
	 * public String getProductPrice() { return productPrice; }
	 * 
	 * public void setProductPrice(String productPrice) { this.productPrice =
	 * productPrice; }
	 * 
	 * public String getProductTitle() { return productTitle; }
	 * 
	 * public void setProductTitle(String productTitle) { this.productTitle =
	 * productTitle; }
	 * 
	 * public String getProductDescription() { return productDescription; }
	 * 
	 * public void setProductDescription(String productDescription) {
	 * this.productDescription = productDescription; }
	 * 
	 * public String getFileName() { return fileName; }
	 * 
	 * public void setFileName(String fileName) { this.fileName = fileName; }
	 * 
	 * public String getFilePath() { return filePath; }
	 * 
	 * public void setFilePath(String filePath) { this.filePath = filePath; }
	 * 
	 * @Override public String toString() { return "AllProducts [productName=" +
	 * productName + ", productPrice=" + productPrice + ", productTitle=" +
	 * productTitle + ", productDescription=" + productDescription + ", fileName=" +
	 * fileName + ", filePath=" + filePath + "]"; }
	 */

  
}
