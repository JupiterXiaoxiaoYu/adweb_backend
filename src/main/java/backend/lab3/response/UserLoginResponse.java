package backend.lab3.response;

public class UserLoginResponse {
    private String message;

    public UserLoginResponse() {
        // Empty constructor required for JSON deserialization
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
