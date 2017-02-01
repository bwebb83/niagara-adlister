import com.mysql.cj.jdbc.Driver;

import java.sql.*;

import java.util.List;

/**
 * Created by Brian on 2/1/17.
 */
public class JdbcAdsDao implements Ads {
    private Connection connection;

    public JdbcAdsDao() throws SQLException{
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        DriverManager.getConnection(
                "jdbc:mysql://localhost/adlister_db",
                "root",
                "codeup"
        );

    }

    @Override
    public List<Ad> all() {
        String sql = "select * from ads";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");

                Ad ad = new Ad(id, title, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
