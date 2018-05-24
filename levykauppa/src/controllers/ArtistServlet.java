package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.AlbumDAO;
import db.ArtistDAO;
import models.Album;
import models.Artist;

/**
 * Servlet implementation class ArtistServlet
 */
@WebServlet("/Artistid")
public class ArtistServlet extends HttpServlet {

	private ArtistDAO artistDao = new ArtistDAO();
	private AlbumDAO albumDao = new AlbumDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long id = Long.parseLong(req.getParameter("id"));

		Artist artist = artistDao.findArtist(id);
		List<Album> albums = albumDao.findAlbumsByArtist(artist);

		if (artist != null && albums != null) {
			req.setAttribute("artist", artist);
			req.setAttribute("albums", albums);
			req.getRequestDispatcher("/WEB-INF/views/artist.jsp").include(req, resp);
		}

		else {
			resp.setStatus(404);
			resp.getWriter().println("Not Found :(");
		}

		// String first = req.getParameter("id");

		// long artistId = Long.parseLong(first);

		// PrintWriter writer = resp.getWriter();
		// Artist artist = artistDao.findArtist(artistId);

		// writer.println(artist.getName());
	}

}
