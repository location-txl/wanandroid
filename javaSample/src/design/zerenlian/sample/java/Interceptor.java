package design.zerenlian.sample.java;

import design.zerenlian.Request;
import design.zerenlian.Response;

public interface Interceptor {
    Response intercept(Chain chain);

    interface Chain{
        Request getRequest();
        Response proceed(Request request);
    }
}
