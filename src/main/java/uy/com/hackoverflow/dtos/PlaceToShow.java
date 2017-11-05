package uy.com.hackoverflow.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import uy.com.hackoverflow.models.Location;

import javax.persistence.*;

/**
 * Created by emiliano on  04/11/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceToShow {
    private Long id;
    private String name;
    private String description;
    private int capacity;
    private Float price;
    private LocationToShow location;

    public PlaceToShow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public LocationToShow getLocation() {
        return location;
    }

    public void setLocation(LocationToShow location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PlaceToShow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                ", location=" + location +
                '}';
    }
}
