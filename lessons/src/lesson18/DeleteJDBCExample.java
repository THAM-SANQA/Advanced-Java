package lesson18;

import java.sql.*;

/**
 * @author thamsanqa 2024
 **/
@SuppressWarnings("unused")
public class DeleteJDBCExample {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/EmployeeDB";
        String username = "postgres";
        String password = "thami82d";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement stmt = con.createStatement();
            String query = "DELETE FROM public.\"Employee\" where \"ID\"=400";
            if (stmt.executeUpdate(query) > 0) {
                System.out.println("An employee record was deleted successfully");
            }
            String query1 = "select * from public.\"Employee\"";
            ResultSet rs = stmt.executeQuery(query1);
        }
    }
}