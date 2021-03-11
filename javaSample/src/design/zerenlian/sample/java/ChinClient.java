package design.zerenlian.sample.java;

import design.zerenlian.Request;
import design.zerenlian.Response;

import java.util.ArrayList;
import java.util.List;

public class ChinClient implements Chin{

    private List<Chin> chinList = new ArrayList<>();

    public void addHandler(Chin chin){
        chinList.add(chin);
    }
    private  int index = 0;
    @Override
    public Response handleEvent(Request request, Chin chin) {
        if(index >= chinList.size()){
            return null;
        }
        Chin nextChin = chinList.get(index++);
        return nextChin.handleEvent(request,chin);
    }

    public void removeHandler(Chin chin){
        chinList.remove(chin);
    }

    public synchronized Response handler(Request request){
        return  handleEvent(request,this);
    }
}
