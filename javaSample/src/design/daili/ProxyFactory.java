package design.daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 */
public class ProxyFactory {


    /**
     * 通用的代理函数
     * 做了一个检测函数耗时
     * @param t 代理的对象
     * @param <T> 代理的对象类型
     * @return 返回代理后的对象
     */
    public <T> T createProxy(final T t) {
        Object target = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), (proxy, method, args) -> {
            long currentTime = System.currentTimeMillis();
            Object result =  method.invoke(t, args);
            long codeTime = System.currentTimeMillis() - currentTime;
            System.out.println( method.getName() + "函数耗时 = " + codeTime);
            return result;
        });

        return (T) target;
    }

    /**
     * 是否打折
     *
     * @return true 打折 false不打折
     */
    private boolean isDiscount() {
        return true;
    }

    /**
     * 代理ShopStore
     * 扩展ShopStore功能 在有节假日时对商品进行打折处理
     * @param shopStore 代理对对象
     * @return 代理后对对象
     */
    public ShopStore createShopStoreProxy(ShopStore shopStore) {
        Object target = Proxy.newProxyInstance(shopStore.getClass().getClassLoader(), shopStore.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    String name = method.getName();
                    if (!"payBanner".equals(name)) {
                        //不等于购买商品函数 直接放行
                        return method.invoke(shopStore, args);
                    }
                    Integer money = (Integer) method.invoke(shopStore, args);
                    if (isDiscount()) {
                        System.out.println("是节假日 原价为" + money + "打8折");
                        //如果是节假日 对商品进行打折
                        money = (int) (money * 0.8);
                    }
                    return money;

                });
        return (ShopStore) target;
    }
}
