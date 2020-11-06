import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

public class Demo {
    public static void main(String[] args) {

        long idToUpdate = 2;
        Config config = new Config();
        ArrayList<Album> albums = new ArrayList<>();

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM albums");

//            insert example
//            String sql = "INSERT INTO albums (artist, name, release_date, sales, genre) VALUES('Nelly Furtado', 'Folklore', 2003, 50, 'Pop')";

//            long latestID = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//            System.out.println("latestID = " + latestID);
//            rs = statement.getGeneratedKeys();
//            if (rs.next()) {
//                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
//            }



//            Delete Example
//            long idToDelete = 35;
//            sql = "DELETE FROM albums WHERE id = " + idToDelete;
//            statement.execute(sql);
//            System.out.println(idToDelete + " is gone");



//              LOOP THROUGH EXAMPLE
//            .next() will check if there is a next result as well.
            while(rs.next()){
                albums.add(new Album(
                        rs.getLong("id"),
                        rs.getString("artist"),
                        rs.getString("name"),
                        rs.getInt("release_date"),
                        rs.getDouble("sales"),
                        rs.getString("genre")
                        )
                );

                for (Album album : albums){
                    System.out.println("album.getId() = " + album.getId());
                    System.out.println("album.getArtist() = " + album.getArtist());
                    System.out.println("album.getName() = " + album.getName());
                    System.out.println("album.getRelease_date() = " + album.getRelease_date());
                    System.out.println("album.getSales() = " + album.getSales());
                    System.out.println("album.getGenre() = " + album.getGenre());

                }

//                album.setId(rs.getLong("id"));
//                album.setName(rs.getString(3));
//                album.setSales(rs.getDouble("sales"));

//                System.out.println("album.getId() = " + album.getId());
//                System.out.println("album.getName() = " + album.getName());
//                System.out.println("album.getSales() = " + album.getSales());

//                System.out.println("rs.getLong(\"id\") = " + rs.getLong("id"));
//                System.out.println("rs.getString(3) = " + rs.getString(3));
            }

//            UPDATE EXAMPLE
//            double sales = 60.5;
//            statement.executeUpdate("UPDATE albums SET sales = " + sales + " WHERE id = " + idToUpdate);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
