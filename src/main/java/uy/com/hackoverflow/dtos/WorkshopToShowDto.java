package uy.com.hackoverflow.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import uy.com.hackoverflow.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkshopToShowDto {
    private Long id;
    private String name;
    private String description;
    private String date;
    private Boolean free;
    private Float price;
    private List<Image> images;
    private List<Tag> tags;
    private Place place;
    private TeacherToShowDto teacher;
    private UserBasic requester;
    private List<UserBasic> enrolledUsers = new ArrayList<>();

    public WorkshopToShowDto() {
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


    public TeacherToShowDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherToShowDto teacher) {
        this.teacher = teacher;
    }

    public UserBasic getRequester() {
        return requester;
    }

    public void setRequester(UserBasic requester) {
        this.requester = requester;
    }

    public List<UserBasic> getEnrolledUsers() {
        return enrolledUsers;
    }

    public void setEnrolledUsers(List<UserBasic> enrolledUsers) {
        this.enrolledUsers = enrolledUsers;
    }

    public static WorkshopToShowDto fromWorkshop(Workshop w){
        WorkshopToShowDto result = new WorkshopToShowDto();
        result.setId(w.getId());
        result.setName(w.getName());
        result.setDescription(w.getDescription());
        result.setDate(w.getDate());
        result.setFree(w.getFree());
        result.setPrice(w.getPrice());
        result.setImages(w.getImages());
        result.setTags(w.getTags());
        result.setPlace(w.getPlace()); // FIXME: change
        result.setTeacher(TeacherToShowDto.fromTeacher(w.getTeacher()));
        result.setRequester(UserBasic.fromUser(w.getRequester()));
        List<UserBasic> enrolledUsers = new ArrayList<>();
        for(User u: w.getEnrolledUsers()){
            UserBasic basic = new UserBasic();
            basic.setUsername(u.getUsername());
            basic.setNickname(u.getNickname());
            basic.setEmail(u.getEmail());
            enrolledUsers.add(basic);
        }
        result.setEnrolledUsers(enrolledUsers);
        return result;
    }

    @Override
    public String toString() {
        return "WorkshopToShowDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", free=" + free +
                ", price=" + price +
                ", images=" + images +
                ", tags=" + tags +
                ", place=" + place +
                ", teacher=" + teacher +
                ", requester=" + requester +
                ", enrolledUsers=" + enrolledUsers +
                '}';
    }
}
