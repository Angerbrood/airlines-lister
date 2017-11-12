package edu.elte.airlines.util;

public class Wrapper {
    private String requestType;
    private Object data;


    public Wrapper() {

    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
