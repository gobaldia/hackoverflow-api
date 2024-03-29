package uy.com.hackoverflow.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Basic Info
    private String nickname;
    private String username;
    private String email;
    private String pwd;
    private Boolean instructor;
    private Boolean student;
    private String dni;
    private Double score = 0D;

    // Relationships
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Workshop> dictatedWorkshops = new ArrayList<>(); /* Cursos que dicto*/

    @ManyToMany(
            targetEntity = Workshop.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "WORKSHOP_ENROLLED",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKSHOP_ID", referencedColumnName = "id")
    )
    private List<Workshop> enrolledWorkshops = new ArrayList<>(); /* Cursos a los que me anote */

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "requester", cascade = CascadeType.ALL)
    private List<Workshop> requestedWorkshops = new ArrayList<>(); /* Cursos que solicito */

    public User() {
        this.score = 0D;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Boolean getInstructor() {
        return instructor;
    }

    public void setInstructor(Boolean instructor) {
        this.instructor = instructor;
    }

    public Boolean getStudent() {
        return student;
    }

    public void setStudent(Boolean student) {
        this.student = student;
    }

    public List<Workshop> getDictatedWorkshops() {
        return dictatedWorkshops;
    }

    public void setDictatedWorkshops(List<Workshop> dictatedWorkshops) {
        this.dictatedWorkshops = dictatedWorkshops;
    }

    public List<Workshop> getEnrolledWorkshops() {
        return enrolledWorkshops;
    }

    public void setEnrolledWorkshops(List<Workshop> enrolledWorkshops) {
        this.enrolledWorkshops = enrolledWorkshops;
    }

    public List<Workshop> getRequestedWorkshops() {
        return requestedWorkshops;
    }

    public void setRequestedWorkshops(List<Workshop> requestedWorkshops) {
        this.requestedWorkshops = requestedWorkshops;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void enrollInWorkshop(Workshop w){
        this.enrolledWorkshops.add(w);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", instructor=" + instructor +
                ", student=" + student +
                ", dni='" + dni + '\'' +
                ", score=" + score +
                '}';
    }
}
