import java.sql.*;

import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

public class Demo {
    public static void main(String[] args) {

        long idToUpdate = 36;

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "codeup");

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM albums");

//            insert example
            String sql = "INSERT INTO albums (artist, name, release_date, sales, genre) VALUES('Nelly Furtado', 'Folklore', 2003, 50, 'Pop')";

            long latestID = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("latestID = " + latestID);
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
            }



//            Delete Example
//            long idToDelete = 35;
//            sql = "DELETE FROM albums WHERE id = " + idToDelete;
//            statement.execute(sql);
//            System.out.println(idToDelete + " is gone");



//              LOOP THROUGH EXAMPLE
//            .next() will check if there is a next result as well.
            while(rs.next()){
                System.out.println("rs.getLong(\"id\") = " + rs.getLong("id"));
                System.out.println("rs.getString(3) = " + rs.getString(3));
            }

//            UPDATE EXAMPLE
            double sales = 60.5;
            statement.executeUpdate("UPDATE albums SET sales = " + sales + " WHERE id = " + idToUpdate);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
