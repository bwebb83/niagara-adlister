public class DaoFactory {
    private static Ads adsDao;

    static Ads getAdsDao(){
        if (adsDao==null){
            adsDao = new JdbcAdsDao(new Config());
        }
        return adsDao;
    }


}

