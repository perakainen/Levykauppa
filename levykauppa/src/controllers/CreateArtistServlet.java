package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ArtistDAO;
import models.Artist;

/**
 * Servlet implementation class CreateARtistServlet
 */
@WebServlet("/Artistnew")
public class CreateArtistServlet extends HttpServlet {

	private ArtistDAO artistDao = new ArtistDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/newArtist.jsp");
		dispatcher.include(req, resp);

		String artistName = req.getParameter("artistName");

		if (artistName == null || artistName.isEmpty()) {

			req.setAttribute("error", "No name given");
			doGet(req, resp);

		} else {
			Artist artist = new Artist(artistName);

			artistDao.storeArtist(artist);

			resp.sendRedirect("/Levykauppa/Artistid?id=" + artist.getId());
		}
	}
}
