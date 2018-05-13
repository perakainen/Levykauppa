package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ArtistDAO;
import models.Artist;

/**
 * Servlet implementation class ArtistServlet
 */
@WebServlet("/Artistid")
public class ArtistServlet extends HttpServlet {

	private ArtistDAO artistDao = new ArtistDAO();
	// private AlbumDAO albumDao = new AlbumDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));

		Artist a = artistDao.findArtist(id);

		if (a != null) {
			request.setAttribute("artist", a);

			request.getRequestDispatcher("/WEB-INF/views/artist.jsp").include(request, response);
		}

		else {
			response.setStatus(404);
			response.getWriter().println("Not found");
		}

		/*
		 * System.out.println(request.getParameter("id")); String first =
		 * request.getParameter("id"); long artistId = Long.parseLong(first);
		 * PrintWriter writer = response.getWriter(); Artist artist =
		 * artistDao.findArtist(artistId);
		 * 
		 * writer.println(artist.getName());
		 */

	}

}
