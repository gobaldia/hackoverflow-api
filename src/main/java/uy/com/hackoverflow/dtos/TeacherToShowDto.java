package uy.com.hackoverflow.dtos;

import uy.com.hackoverflow.models.User;

/**
 * Created by emiliano on  04/11/17.
 */
public class TeacherToShowDto {
    private String nickname;
    private String username;
    private String email;
    private Double score = 0D;

    public TeacherToShowDto() {
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public static TeacherToShowDto fromTeacher(User u){
        TeacherToShowDto result = new TeacherToShowDto();
        result.setEmail(u.getEmail());
        result.setNickname(u.getNickname());
        result.setScore(u.getScore());
        result.setUsername(u.getUsername());
        return result;
    }
    @Override
    public String toString() {
        return "TeacherToShowDto{" +
                "nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                '}';
    }
}
