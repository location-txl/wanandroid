package design.daili;

public class BannerShopStore implements ShopStore {

    /**
     * 单价
     */
    private  static final int PRICE = 3;
    @Override
    public int payBanner(int num) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 3 * num;
    }
}
