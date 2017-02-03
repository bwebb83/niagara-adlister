import java.util.List;

public interface Ads {
    List<Ad> all(); //throws SQLException;  // not all implementations will throw this exception
    void insert(Ad ad);
    Ad find(long id);
}