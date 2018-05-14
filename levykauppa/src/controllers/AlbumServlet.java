package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.AlbumDAO;
import db.TrackDAO;
import models.Album;
import models.Track;

/**
 * Servlet implementation class AlbumServlet
 */
@WebServlet("/Albumid")
public class AlbumServlet extends HttpServlet {

	private AlbumDAO albumDao = new AlbumDAO();
	private TrackDAO trackDao = new TrackDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long id = Long.parseLong(req.getParameter("id"));

		Album a = albumDao.findAlbum(id);
		List<Track> track = trackDao.findTracksByAlbum(a);

		if (a != null && track != null) {
			req.setAttribute("album", a);
			req.setAttribute("track", track);
			req.getRequestDispatcher("/WEB-INF/views/album.jsp").include(req, resp);
		}

		else {
			resp.setStatus(404);
			resp.getWriter().println("Not Found :(");
		}

		// String first = req.getParameter("id");

		// long albumId = Long.parseLong(first);

		// PrintWriter writer = resp.getWriter();
		// Album album = albumDao.findAlbum(albumId);

		// writer.println(album.getName());
	}

}
