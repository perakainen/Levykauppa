package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Album;
import models.Artist;

public class AlbumDAO {

	private final ChinookDatabase db;

	public AlbumDAO() {
		db = new ChinookDatabase();
	}

	public Album findAlbum(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT * FROM Album WHERE AlbumId = ?");
			statement.setLong(1, id);
			results = statement.executeQuery();

			if (results.next()) {
				String name = results.getString("Title");
				long albumId = results.getLong("AlbumId");
				return new Album(albumId, name);
			}
		}

		catch (Exception e) {
			throw new RuntimeException(e);
		}

		finally {
			db.closeAll(connection, statement, results);
		}

		return null;
	}

	public List<Album> findAllAlbums() throws Exception {
		Connection con = db.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Album");
		ResultSet results = statement.executeQuery();

		List<Album> allAlbums = new ArrayList<>();

		while (results.next()) {
			long id = results.getLong("AlbumId");
			String name = results.getString("Name");

			Album a = new Album(id, name);

			allAlbums.add(a);
		}

		results.close();
		statement.close();
		con.close();

		return allAlbums;
	}

	public List<Album> findAlbumsByArtist(Artist artist) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement(
					"SELECT Name, Title FROM Artist a JOIN Album al ON al.AlbumId = a.ArtistId WHERE Name = ?");

			String artistiNimi = artist.getName();
			statement.setString(1, artistiNimi); // Indexi-virhe??

			results = statement.executeQuery();

			List<Album> matchingAlbums = new ArrayList<>();

			while (results.next()) {
				String albumName = results.getString("Name");
				Album a = new Album(albumName);

				matchingAlbums.add(a);

			}
			return matchingAlbums;
		}

		catch (Exception e) {

		}

		finally {
			db.closeAll(connection, statement, results);
		}

		return null;

	}

	public List<Album> findAlbumsByTitle(String title) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("SECELT * FROM Albums WHERE ");

		} catch (Exception e) {

		} finally {
			db.closeAll(connection, statement, results);
		}

		return null;
	}

	public void storeAlbum(Album album) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("INSERT INTO Album (Name) VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, album.getTitle());
			statement.executeUpdate();

			results = statement.getGeneratedKeys();

			if (results.next()) {
				long id = results.getLong(1);
				album.setId(id);
			}
		}

		catch (Exception e) {
			throw new RuntimeException(e);

		}

		finally {
			db.closeAll(connection, statement, results);
		}
	}
}