package controllers;

import java.io.IOException;
import java.io.PrintWriter;

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
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// dispatcher.include(req, resp);

		PrintWriter writer = resp.getWriter();

		String artistName = req.getParameter("name");

		if (!artistName.isEmpty() || !"".equals(artistName)) {

			Artist artist = new Artist(artistName);

			artistDao.storeArtist(artist);

			writer.println("Artistin luonti onnistui!");
		}

		else {

			writer.println("Luominen epäonnistui!");

		}

	}
}
