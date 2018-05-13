package models;

public class Album {
	private long id;
	private String name;

	public Album(String name) {
		this.name = name;
	}

	public Album(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.name;
	}

}
