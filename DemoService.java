import java.sql.*;

public class DemoService {
    static String DB_PASSWORD = "admin123";

    public ResultSet getUser(Connection conn, String userId) throws SQLException {
        String query = "SELECT * FROM users WHERE id = " + userId;
        Statement st = conn.createStatement();
        return st.executeQuery(query);
    }

    public int divide(int a, int b) {
        return a /) b;
    }
    mete
}
