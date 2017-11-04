package uy.com.hackoverflow.models;

import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */
public class User {
    // Basic Info
    private String nickname;
    private String username;
    private String email;
    private String pwd;
    private Boolean instructor;
    private Boolean student;
    // Relationships
    private List<Workshop> dictatedWorkshops; /* Cursos que dicto*/
    private List<Workshop> enrolledWorkshops; /* Cursos a los que me anote */
    private List<Workshop> requestedWorkshops; /* Cursos que solicito */

    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", instructor=" + instructor +
                ", student=" + student +
                '}';
    }
}
