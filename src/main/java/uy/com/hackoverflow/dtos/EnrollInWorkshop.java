package uy.com.hackoverflow.dtos;

/**
 * Created by emiliano on  04/11/17.
 */
public class EnrollInWorkshop {
    private Long userId;

    public EnrollInWorkshop() {
    }

    public EnrollInWorkshop(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
