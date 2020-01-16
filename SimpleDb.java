package by.select.stage5.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleDb {
	public static void main(String[] args) {
		SimpleDb m = new SimpleDb();
		m.read();
	}

	private void read() {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/flower";
			String login = "postgres";
			String password = "kayashev90";
			Connection con = DriverManager.getConnection(url, login, password);
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM ROSE");
				while (rs.next()) {
					String str = rs.getString("flower_id") + ":" + rs.getString(2);
					System.out.println("flower:" + str);
				}
				rs.close();
				stmt.close();
			} finally {
				con.close();
			}
		} catch (SQLException  e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}