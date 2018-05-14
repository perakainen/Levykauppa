package models;

public class Album {
	private long id;
	private String title;

	public Album(String name) {
		this.title = name;
	}

	public Album(long id, String name) {
		this.id = id;
		this.title = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String toString() {
		return this.title;
	}

}
