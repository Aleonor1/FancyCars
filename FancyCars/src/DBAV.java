import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.derby.iapi.sql.PreparedStatement;

public class DBAV extends Mainn {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby://localhost:1527/DBAV;create=true";

	public static void creareBD() throws ClassNotFoundException, SQLException {
		Connection connection = DriverManager.getConnection(JDBC_URL);
		if (connection != null) {
			DatabaseMetaData dbMetaData = connection.getMetaData();
			ResultSet resultSet = dbMetaData.getTables(null, null, "AUTOVEHICULE", null);
			if (resultSet.next()) {
				// System.out.println("Tabelul "+ resultSet.getString(3) + " exista!");
				// tabelul exista deja
			} else {
				connection.createStatement().execute(
						"CREATE table autovehicule(categorie VARCHAR2(20) NOT NULL, nrInmatriculare VARCHAR2(20) NOT NULL, "
								+ "marca VARCHAR2(20) NOT NULL, dataInmatriculare DATE NOT NULL, prorpietar VARCHAR2(20) NOT NULL, dataUltimeiRevizii DATE NOT NULL, "
								+ "tipCombustibil VARCHAR2(20) NOT NULL, culoare VARCHAR2(20) NOT NULL, motorizare INTEGER NOT NULL, caracteristica1 VARCHAR2(20), "
								+ "caracteristica2 VARCHAR2(20), caracteristica3 VARCHAR2(20), PRIMARY KEY(nrInmatriculare))");
				// System.out.println("tabelul AUTOVEHICULE s-a creat");
				// tabelul a fost creat
			}
		}
	}

	public static void adaugareSimpla() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		// inserare simpla
		connection.createStatement().execute("insert into autovehicule values "
				+ "('a', 'a', 'a', '2018-10-20', 'a', '2018-10-20', 'a', 'a', 200, 'a', 'a', 'a')");
		System.out.println("autovehiculul a fost adaugat cu succes");
	}

	public static void adaugareAutovehicul(Autovehicul a) throws ClassNotFoundException, SQLException {
		Connection connection = DriverManager.getConnection(JDBC_URL);
		try {
			Class.forName(DRIVER);
			connection.createStatement()
					.execute("insert into autovehicule values " + "('" + a.get_tip() + "', '" + a.get_nr_matriculare()
							+ "', '" + a.getMarca() + "', '" + a.get_data_inmatriculare() + "', '" + a.get_nume()
							+ "', '" + a.getData_ultimei_revizii() + "', '" + a.getTip_combustibil() + "', '"
							+ a.getCuloare() + "', " + a.getMotorizare() + ", 'a', 'a', 'a')");
		} catch (SQLException ex) {
			final String ss = ex.getSQLState();
			System.out.println("Deja exista autovehicululu cu numarul de inmatriculare" + a.get_nr_matriculare()
					+ "inscris in baza de date.");
		} catch (Exception se) {
			se.printStackTrace();
		}
	}

	public static void stergere(String nr_inmatriculare) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("DELETE FROM autovehicule WHERE nrInmatriculare = ?");
		System.out.println("Datele din tabel au fost sterse.");
	}

	public static void deleteRow(String nrInmatriculare) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE from AUTOVEHICULE WHERE NRINMATRICULARE=" + "'" + nrInmatriculare + "'");

	}

	public static void drop() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("DROP TABLE autovehicule");
		System.out.println("Tabelul a fost sters.");
	}

	public static void afisare(String e) throws ClassNotFoundException, SQLException {
		final String SQL_STATEMENT = "select * from AUTOVEHICULE WHERE NRINMATRICULARE=" + "'" + e + "'";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int nrColoane = resultSetMetaData.getColumnCount();
		for (int i = 1; i <= nrColoane; i++)
			System.out.format("%20s", resultSetMetaData.getColumnName(i) + " | ");

		while (resultSet.next()) {
			System.out.println("");
			for (int i = 1; i <= nrColoane; i++)
				System.out.format("%20s", resultSet.getString(i) + " | ");
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

	public static void afisare() throws ClassNotFoundException, SQLException {
		final String SQL_STATEMENT = "select * from AUTOVEHICULE";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int nrColoane = resultSetMetaData.getColumnCount();
		for (int i = 1; i <= nrColoane; i++)
			System.out.format("%20s", resultSetMetaData.getColumnName(i) + " | ");

		while (resultSet.next()) {
			System.out.println("");
			for (int i = 1; i <= nrColoane; i++)
				System.out.format("%20s", resultSet.getString(i) + " | ");
		}
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

	public static void cautare(String what) throws ClassNotFoundException, SQLException {
		final String SQL_STATEMENT = "select * from AUTOVEHICULE WHERE NRINMATRICULARE=" + "'" + what + "'";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		if (!resultSet.next()) {
			AdaugareAutovehicul.exista = false;
		} else {
			AdaugareAutovehicul.exista = true;
		}
	}

	public static boolean cautare2(String what) throws ClassNotFoundException, SQLException {
		final String SQL_STATEMENT = "select * from AUTOVEHICULE WHERE NRINMATRICULARE=" + "'" + what + "'";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		if (!resultSet.next()) {
			return false;
		} else {
			return true;
		}
	}

	public static ResultSet cautare3(String what) throws ClassNotFoundException, SQLException {
		final String SQL_STATEMENT = "select * from AUTOVEHICULE WHERE NRINMATRICULARE=" + "'" + what + "'";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}

	public static ResultSet DupaNume(String what) throws ClassNotFoundException, SQLException {
		final String SQL_STATEMENT = "select * from AUTOVEHICULE WHERE prorpietar=" + "'" + what + "'";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet AutovehiculeDupaData(String data) throws ClassNotFoundException, SQLException{
		final String SQL_STATEMENT = "select * from AUTOVEHICULE where dataInmatriculare>"+"'"+data+"'";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	
	public static ResultSet AutovehiculeInainteData(String data) throws ClassNotFoundException, SQLException{
		final String SQL_STATEMENT = "select * from AUTOVEHICULE where dataInmatriculare < "+"'"+data+"'";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	public static ResultSet AutovehiculeDupaTip() throws ClassNotFoundException, SQLException{
		final String SQL_STATEMENT = "select categorie, nrInmatriculare from AUTOVEHICULE order by categorie, nrInmatriculare";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		return resultSet;
	}
	public static void UpdateDate(String what) throws SQLException {
		final String SQL_STATEMENT = "update AUTOVEHICULE set dataUltimeiRevizii=? WHERE NRINMATRICULARE=?";
		Connection connection = DriverManager.getConnection(JDBC_URL);
		Statement statement = connection.createStatement();
		Date data = new Date();
		String sarmale = data.toString();
		java.sql.PreparedStatement pstmt = connection.prepareStatement(SQL_STATEMENT);
		pstmt.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
		pstmt.setString(2, what);
		pstmt.executeUpdate();
	}
	
}
