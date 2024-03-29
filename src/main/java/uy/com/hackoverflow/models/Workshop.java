package uy.com.hackoverflow.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */
@Entity
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Column( length = 10000 )
    private String description;
    private String date;
    private Boolean free;
    private Float price;

    @ElementCollection
    private List<Image> images;

    @ElementCollection
    private List<Tag> tags;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "placeId")
    private Place place;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacherId")
    private User teacher;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "requesterId")
    private User requester;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE}, mappedBy = "enrolledWorkshops", targetEntity = User.class)
    private List<User> enrolledUsers = new ArrayList<>();

    public Workshop() {
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public List<User> getEnrolledUsers() {
        return enrolledUsers;
    }

    public void enrollStudent(User u){
        this.enrolledUsers.add(u);
    }

    @Override
    public String toString() {
        return "WorkshopRepository{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", free=" + free +
                ", price=" + price +
                ", images=" + images +
                ", tags=" + tags +
                '}';
    }
}
