package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Album;
import models.Track;

public class TrackDAO {
	// KIRJOITA LISÄÄÄ

	private final ChinookDatabase db;

	public TrackDAO() {
		db = new ChinookDatabase();
	}

	public Track findTrack(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT TrackId, Name FROM Track WHERE TrackId = ?");
			statement.setLong(1, id);
			results = statement.executeQuery();

			if (results.next()) {
				String name = results.getString("Name");
				long trackId = results.getLong("TrackId");
				return new Track(trackId, name);

			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}

		return null;

	}

	public List<Track> findAllTrack() throws Exception {
		Connection connection = db.connect();
		PreparedStatement statement = connection.prepareStatement("SELECT TrackId, Name FROM Track");
		ResultSet results = statement.executeQuery();

		List<Track> allTracks = new ArrayList<>();

		while (results.next()) {
			long id = results.getLong("TrackId");
			String name = results.getString("Name");

			Track t = new Track(id, name);

			allTracks.add(t);
		}

		results.close();
		statement.close();
		connection.close();

		return allTracks;
	}

	List<Track> findTracksByAlbum(Album album) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement(
					"SELECT TrackId, Name FROM Track t JOIN Album a ON a.AlbumId = t.TrackId WHERE a.Title = ?");
			statement.setString(1, album.toString());
			// System.out.println(album.toString());
			results = statement.executeQuery();

			List<Track> matchingTracks = new ArrayList<>();

			while (results.next()) {

				String trackName = results.getString("Name");
				Track t = new Track(trackName);

				matchingTracks.add(t);
			}
			return matchingTracks;

		} catch (Exception e) {

		} finally {
			db.closeAll(connection, statement, results);
		}
		return null;
	}

	public void storeTrack(Track track) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("INSERT INTO Track (Name) VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, track.getName());
			statement.executeUpdate();

			results = statement.getGeneratedKeys();

			if (results.next()) {
				long id = results.getLong(1);
				track.setId(id);
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
