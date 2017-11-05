package uy.com.hackoverflow.dtos;

import uy.com.hackoverflow.models.Image;
import uy.com.hackoverflow.models.Tag;

import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */
public class RegisterWorkshop {

    private String name;
    private String description;
    private String date;
    private Boolean free;
    private Float price;
    private List<Image> images;
    private List<Tag> tags;
    private PlaceToShow place;

    public RegisterWorkshop() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public PlaceToShow getPlace() {
        return place;
    }

    public void setPlace(PlaceToShow place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "RegisterWorkshop{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", free=" + free +
                ", price=" + price +
                ", images=" + images +
                ", tags=" + tags +
                ", place=" + place +
                '}';
    }
}
