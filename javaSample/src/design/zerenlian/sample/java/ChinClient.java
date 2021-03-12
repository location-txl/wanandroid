package design.zerenlian.sample.java;

import design.zerenlian.Request;
import design.zerenlian.Response;

import java.util.ArrayList;
import java.util.List;

public class ChinClient implements Interceptor.Chain {

    private List<Interceptor> interceptorList = new ArrayList<>();

    public void addInterceptor(Interceptor interceptor) {
        interceptorList.add(interceptor);
    }

    private int index = 0;


    public void removeInterceptor(Interceptor interceptor) {
        interceptorList.remove(interceptor);
    }


    private Request request;

    @Override
    public Request getRequest() {
        return request;
    }

    @Override
    public Response proceed(Request request) {
        this.request = request;
        if (index >= interceptorList.size()) {
            return null;
        }
        Interceptor interceptor = interceptorList.get(index++);
        return interceptor.intercept(this);
    }
}
