package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ChinookDatabase {

	private static final String URL = "jdbc:sqlite:C:\\Users\\kesku\\Desktop\\Skööl\\AmmattikorkeaKoulu\\Java\\harjoitustyo\\chinook\\Chinook_Sqlite.sqlite";

	public Connection connect() throws SQLException, ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");

		return DriverManager.getConnection(URL);

	}

	public void closeAll(Connection connection, PreparedStatement statement, ResultSet results) {
		close(results);
		close(statement);
		close(connection);
	}

	private void close(AutoCloseable object) {
		if (object != null) {
			try {
				object.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
