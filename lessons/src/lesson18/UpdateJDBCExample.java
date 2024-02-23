package lesson18;

import java.sql.*;

/**
 * @author thamsanqa 2024
 **/
public class UpdateJDBCExample {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/EmployeeDB";
        String username = "postgres";
        String password = "thami82d";
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement stmt = con.createStatement();
            String query = "Update public.\"Employee\" SET \"SALARY\"= 200000 where \"ID\"=500";
            if (stmt.executeUpdate(query) > 0) {
                System.out.println("An existing employee record was updated successfully!");
            }
            String query1 = "select * from public.\"Employee\"";
            ResultSet rs = stmt.executeQuery(query1);
            //code to display the records//
        }
    }
}