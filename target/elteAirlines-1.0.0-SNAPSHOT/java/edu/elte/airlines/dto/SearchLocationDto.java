package edu.elte.airlines.dto;

public class SearchLocationDto {
    private String toCity;
    private String fromCity;

    public SearchLocationDto() {

    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }
}
