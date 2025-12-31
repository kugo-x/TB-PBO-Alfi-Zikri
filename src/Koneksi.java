import java.sql.*;
class Koneksi{
private static final String URL = "jdbc:mysql://localhost:3306/db_fotocopy";
private static final String USER = "root";
private static final String PASSWORD = "";
static {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
System.out.println("MySQL JDBC Driver not found in classpath: " + e.getMessage());
}
}
public static Connection getConnection() throws SQLException {
return DriverManager.getConnection(URL, USER, PASSWORD);
}
public static void checkConnection() {
try (Connection conn = getConnection()) {
System.out.println("Koneksi MySQL berhasil.");
} catch (SQLException e) {
System.out.println("Koneksi ke database gagal: " + e.getMessage());
}
}
}
