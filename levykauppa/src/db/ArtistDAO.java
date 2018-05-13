package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Artist;

public class ArtistDAO {

	private final ChinookDatabase db;

	public ArtistDAO() {
		db = new ChinookDatabase();
	}

	public Artist findArtist(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT * FROM Artist WHERE ArtistId = ?");
			statement.setLong(1, id);
			results = statement.executeQuery();

			if (results.next()) {
				String name = results.getString("Name");
				long artistId = results.getLong("ArtistId");
				return new Artist(artistId, name);
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

	public List<Artist> findAllArtists() throws Exception {
		Connection con = db.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Artist");
		ResultSet results = statement.executeQuery();

		List<Artist> allArtists = new ArrayList<>();

		while (results.next()) {
			long id = results.getLong("ArtistId");
			String name = results.getString("Name");

			Artist a = new Artist(id, name);

			allArtists.add(a);
		}

		results.close();
		statement.close();
		con.close();

		return allArtists;
	}

	List<Artist> findArtistByName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT * FROM Artist WHERE Name = ?");

			statement.setString(1, name);
			results = statement.executeQuery();

			List<Artist> matchingArtists = new ArrayList<>();

			while (results.next()) {
				String artistName = results.getString("Name");
				Artist a = new Artist(artistName);

				matchingArtists.add(a);
			}
			return matchingArtists;

		} catch (Exception e) {

		} finally {

			db.closeAll(connection, statement, results);

		}
		return null;

	}

	public void storeArtist(Artist artist) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("INSERT INTO Artist (Name) VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, artist.getName());

			statement.executeUpdate();

			results = statement.getGeneratedKeys();

			if (results.next()) {
				long id = results.getLong(1);
				artist.setId(id);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
	}

}