package backend.lab3.response;
import backend.lab3.mybatis.po.User;
public class UserLoginResponse {
    private String message;
    private User user;

    public UserLoginResponse() {
        // Empty constructor required for JSON deserialization
    }

    public UserLoginResponse(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserLoginResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
