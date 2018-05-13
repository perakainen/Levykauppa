package models;

public class Track {
	private long id;
	private String name;

	public Track(String name) {
		this.name = name;
	}

	public Track(long id, String name) {
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
