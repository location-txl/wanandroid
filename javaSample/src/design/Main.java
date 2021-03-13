package design;

import design.daili.ShopStore;
import design.daili.ProxyFactory;
import design.daili.BannerShopStore;
import design.zerenlian.Request;
import design.zerenlian.Response;
import design.zerenlian.sample.java.AInterceptor;
import design.zerenlian.sample.java.BInterceptor;
import design.zerenlian.sample.java.CInterceptor;
import design.zerenlian.sample.java.ChinClient;
import org.junit.Test;

public class Main {


    /**
     * 责任链模式
     */
    @Test
    public void testZeRenLian(){
        ChinClient client = new ChinClient();
        client.addInterceptor(new AInterceptor());
        client.addInterceptor(new BInterceptor());
        client.addInterceptor(new CInterceptor());
        Response response = client.proceed(new Request("拦截器", 260));
        System.out.println(response.getBody());
    }

    /**
     * 代理模式
     */
    @Test
    public void daili() {
        ProxyFactory proxy = new ProxyFactory();
        ShopStore shopStore = new BannerShopStore();
        ShopStore proxyService = proxy.createProxy(shopStore);
        proxyService.payBanner(3);
        ShopStore shopStoreProxy = proxy.createShopStoreProxy(shopStore);
        System.out.println("shopStoreProxy.payBanner(3) = " + shopStoreProxy.payBanner(3));

    }
}
