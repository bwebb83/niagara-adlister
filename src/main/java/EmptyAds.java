import java.util.ArrayList;
import java.util.List;

/**
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */

public class EmptyAds implements Ads {
    @Override
    public List<Ad> all() {
        return new ArrayList<>();
    }

    @Override
    public void insert(Ad ad) {
    }

    @Override
    public Ad find(long id) {
        return null;
    }
}
