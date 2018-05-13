package models;

public class Artist {
	private long id;
	private String name;

	public Artist(String name) {
		this.name = name;
	}

	public Artist(long id, String name) {
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
