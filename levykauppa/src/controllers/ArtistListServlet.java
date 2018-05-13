package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ArtistDAO;
import models.Artist;

@WebServlet("/Artist")
public class ArtistListServlet extends HttpServlet {

	private ArtistDAO artistDao = new ArtistDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		try {
			List<Artist> artistit = artistDao.findAllArtists();

			for (Artist lista : artistit) {
				writer.println(lista.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
