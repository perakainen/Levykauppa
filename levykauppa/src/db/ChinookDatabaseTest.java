package db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class ChinookDatabaseTest {

	private ChinookDatabase db;

	@Before
	public void SetUp() throws Exception {
		db = new ChinookDatabase();
	}

	@Test
	public void testOpeningConnection() throws ClassNotFoundException, SQLException {
		Connection connection = db.connect();
		assertNotNull(connection);
	}

}
