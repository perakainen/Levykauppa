package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ArtistDAO;

/**
 * Servlet implementation class CreateARtistServlet
 */
@WebServlet("/artist/new")
public class CreateArtistServlet extends HttpServlet {
	private ArtistDAO artistDao = new ArtistDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/new_artist.jsp");
		dispatcher.include(request, response);
	}
}
