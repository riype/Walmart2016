package com.walmart.labs.api.model;

public class Product implements Comparable<Product> {

	long itemId;
	String name;
	String brandName;
	String shortDescription;
	String upc;
	Double msrp;
	Double salePrice;
	String thumbnailImage;
	String mediumImage;
	String largeImage;
	Double itemRating;
	String customerRatingImage;

	
	@Override
	public String toString() {
		return "Product [itemId=" + itemId + ", name=" + name + ", brandName=" + brandName + ", shortDescription="
				+ shortDescription + ", upc=" + upc + ", msrp=" + msrp + ", salePrice=" + salePrice
				+ ", thumbnailImage=" + thumbnailImage + ", mediumImage=" + mediumImage + ", largeImage=" + largeImage
				+ ", itemRating=" + itemRating + ", customerRatingImage=" + customerRatingImage + "]";
	}

	public Double getItemRating() {
		return itemRating;
	}

	public void setItemRating(Double itemRating) {
		this.itemRating = itemRating;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Double getMsrp() {
		return msrp;
	}

	public void setMsrp(Double msrp) {
		this.msrp = msrp;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public String getMediumImage() {
		return mediumImage;
	}

	public void setMediumImage(String mediumImage) {
		this.mediumImage = mediumImage;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	public String getCustomerRatingImage() {
		return customerRatingImage;
	}

	public void setCustomerRatingImage(String customerRatingImage) {
		this.customerRatingImage = customerRatingImage;
	}

	public int compareTo(Product o) {
		int ret=0;
		if(this.itemRating < o.itemRating)
			ret=1;
		else
			if(this.itemRating > o.itemRating)
				ret=-1;
		return ret;
	}

}
