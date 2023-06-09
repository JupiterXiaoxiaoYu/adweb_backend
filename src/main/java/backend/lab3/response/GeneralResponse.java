package backend.lab3.response;

public class GeneralResponse {
    private String message;

    public GeneralResponse() {
        // Empty constructor required for JSON deserialization
    }

    public GeneralResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
