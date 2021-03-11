package design.zerenlian.sample.java;

import design.zerenlian.Request;
import design.zerenlian.Response;

public class CChin implements Chin{
    @Override
    public Response handleEvent(Request request, Chin chin) {
        if(request.getCode() < 300){
            return new Response(request.getParams() + " " +getClass().getSimpleName()+" 已经处理");
        }else {
            request.setParams(request.getParams()+"| 经过"+getClass().getSimpleName());
        }
        return chin.handleEvent(request, chin);
    }
}
