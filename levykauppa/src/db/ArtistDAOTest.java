package db;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import models.Artist;

public class ArtistDAOTest {

	private ArtistDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new ArtistDAO();
	}

	@Test
	public void testFirstArtist() throws Exception {
		List<Artist> artists = dao.findAllArtists();

		Artist first = artists.get(0);

		assertEquals("AC/DC", first.getName());
	}

	@Test
	public void testSecondArtist() throws Exception {
		List<Artist> artists = dao.findAllArtists();

		Artist second = artists.get(1);

		assertEquals("Accept", second.getName());
	}

}
