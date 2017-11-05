package uy.com.hackoverflow.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by emiliano on  04/11/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationToShow {
    private Long id;
    private Double latitude;
    private Double longitude;
    private String state;
    private String city;
    private String addressLine;

    public LocationToShow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
}
