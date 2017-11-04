package uy.com.hackoverflow.dtos;

/**
 * Created by emiliano on  04/11/17.
 */
public class UserLoginInfo {
    private String nick;
    private String pwd;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserLoginInfo{" +
                "nick='" + nick + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
