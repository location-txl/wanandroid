package design.zerenlian.sample.java;

import design.zerenlian.Request;
import design.zerenlian.Response;

public interface Chin {
    Response handleEvent(Request request, Chin chin);
}
