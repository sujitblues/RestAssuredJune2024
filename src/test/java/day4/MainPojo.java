package day4;

import java.util.List;

public class MainPojo {
	private int id;
	private categoryPojo category;
	private String name;
	private String[] photoUrls;
private List<TagsPojo> tags;
public List<TagsPojo> getTags() {
	return tags;
}
public void setTags(List<TagsPojo> tags) {
	this.tags = tags;
}
private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public categoryPojo getCategory() {
		return category;
	}
	public void setCategory(categoryPojo category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
