package db;

import models.Album;

public class Demo {

	private static final ArtistDAO artistDao = new ArtistDAO();
	private static final TrackDAO trackDao = new TrackDAO();

	public static void main(String[] args) throws Exception {

		// Scanner reader = new Scanner(System.in);

		TrackDAO etsiKappaleitaAlbumilla = new TrackDAO();

		Album a = new Album("Balls to the Wall");
		System.out.println(etsiKappaleitaAlbumilla.findTracksByAlbum(a));

		// System.out.println("Anna Nimi");
		// String nimi = reader.nextLine();

		// Artist darude = new Artist("Darude");
		// artistDao.storeArtist(darude);

		// System.out.println("Tässä id darudelle: " + darude.getId());

		// System.out.print("Anna ID: ");
		// long id = Long.parseLong(reader.nextLine());

		// ArtistDAO etsiArtisti = new ArtistDAO();

		// System.out.println(etsiArtisti.findArtist(id).toString());

	}

}
