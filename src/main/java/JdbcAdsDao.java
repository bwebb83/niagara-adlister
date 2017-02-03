

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcAdsDao implements Ads {
    private Connection connection;

    public JdbcAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ad> all() { //checked
        String sql = "SELECT * FROM ads";
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");

                long userId = resultSet.getLong("user_id");

                Ad ad = new Ad(id, userId, title, description);
                ads.add(ad);
            }
        } catch (SQLException e) {
            // re-throw an exception
            // wrapping the exception inside a unchecked exception
            throw new RuntimeException(e);
        }
        return ads;
    }

    @Override
    public void insert(Ad ad) {
        String sql = "INSERT INTO ads (user_id, title, description) " +
                "VALUES (" + ad.getUserId()
                + ", '" + ad.getTitle() + "', '" + ad.getDescription()
                + "')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();

            long id = generatedKeys.getLong(1);
            ad.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ad find(long id) {
        String sql = "SELECT * FROM ads WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                long userId = resultSet.getLong("user_id");

                return new Ad(id, userId, title, description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}