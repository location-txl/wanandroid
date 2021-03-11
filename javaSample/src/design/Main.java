package design;

import design.daili.ShopStore;
import design.daili.ProxyFactory;
import design.daili.BannerServiceImpl;
import design.zerenlian.Request;
import design.zerenlian.Response;
import design.zerenlian.sample.java.AChin;
import design.zerenlian.sample.java.BChin;
import design.zerenlian.sample.java.CChin;
import design.zerenlian.sample.java.ChinClient;
import org.junit.Test;

public class Main {


    /**
     * 责任链模式
     */
    @Test
    public void testZeRenLian(){
        ChinClient client = new ChinClient();
        client.addHandler(new AChin());
        client.addHandler(new BChin());
        client.addHandler(new CChin());
        Response response = client.handler(new Request("拦截器", 260));
        System.out.println(response.getTitle());
    }

    /**
     * 代理模式
     */
    @Test
    public void daili() {
        ProxyFactory proxy = new ProxyFactory();
        ShopStore shopStore = new BannerServiceImpl();
        ShopStore proxyService = proxy.createProxy(shopStore);
        proxyService.payBanner(3);
        ShopStore shopStoreProxy = proxy.createShopStoreProxy(shopStore);
        System.out.println("shopStoreProxy.payBanner(3) = " + shopStoreProxy.payBanner(3));

    }
}
