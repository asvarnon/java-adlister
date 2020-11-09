import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class MySQLAdsDao implements Ads {

    private Connection connection = null;
    private Config config = new Config();

    //List variable to start all();
    private List<Ad> ads;


    //testing connection with config file login
    public MySQLAdsDao(){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }


    //now to implement List all() method as per in the contract (interface)
    public List<Ad> all() {
        //going to make statements and make a list, declare statment and new arraylist
        Statement stmt = null;
        List<Ad> ads = new ArrayList<>();

        //in this list method, executing SQL statement and returning result set
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            //start while with .next() bc it has to move down to first input
            while(rs.next()){
                //pulling ads from DB into arraylist to manipulate in java
                ads.add(new Ad(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getNString("description")
                ));
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        //make sure to return ads arraylist
        return ads;
    }


    public Long insert(Ad ad) {
        return 0L;
    }

}
