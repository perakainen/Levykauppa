package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintAllNames {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ChinookDatabase db = new ChinookDatabase();

		Connection con = db.connect();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Artist");
		ResultSet results = statement.executeQuery();

		results.next();

		while (results.next()) {
			String name = results.getString("Name");
			System.out.println(name);
		}

		results.close();
		statement.close();
		con.close();
	}

}
