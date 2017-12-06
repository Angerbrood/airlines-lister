package edu.elte.airlines.dto;

public class FlightDto {
    private String id;
    private String airlineId;
    private String number;
    private String startLocationId;
    private String endLocationId;
    private String startDate;
    private String endDate;
    private String travelingTime;

    public FlightDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStartLocationId() {
        return startLocationId;
    }

    public void setStartLocationId(String startLocationId) {
        this.startLocationId = startLocationId;
    }

    public String getEndLocationId() {
        return endLocationId;
    }

    public void setEndLocationId(String endLocationId) {
        this.endLocationId = endLocationId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTravelingTime() {
        return travelingTime;
    }

    public void setTravelingTime(String travelingTime) {
        this.travelingTime = travelingTime;
    }
}
