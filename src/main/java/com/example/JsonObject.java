package com.example;

public class JsonObject {
	private String publishedTime;
	private String authorName;
	private String discription;
	private String titel;
	private String imageUrl;
	private String articleUrl;

	public JsonObject(){};
	public JsonObject(String publishedTime,String authorName,String discription,String titel,String imageUrl,String articleUrl){
		this.setPublishedTime(publishedTime);
		this.setAuthorName(authorName);	
		this.setDiscription(discription);	
		this.setTitel(titel);	
		this.setImageUrl(imageUrl);
		this.setArticleUrl(articleUrl);


	}
	public String getArticleUrl() {
		return articleUrl;
	}
	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublishedTime() {
		return publishedTime;
	}
	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}
}
