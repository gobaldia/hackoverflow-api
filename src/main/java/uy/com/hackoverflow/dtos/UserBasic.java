package uy.com.hackoverflow.dtos;

import uy.com.hackoverflow.models.User;

/**
 * Created by emiliano on  04/11/17.
 */
public class UserBasic {
    private String nickname;
    private String username;
    private String email;

    public UserBasic() {
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

    public static UserBasic fromUser(User u){
        UserBasic result =  new UserBasic();
        result.setEmail(u.getEmail());
        result.setNickname(u.getNickname());
        result.setUsername(u.getUsername());
        return result;
    }

    @Override
    public String toString() {
        return "UserBasic{" +
                "nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
