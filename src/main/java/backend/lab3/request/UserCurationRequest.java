package backend.lab3.request;

public class UserCurationRequest {
    private String curationItems;

    public UserCurationRequest() {
        // Empty constructor required for JSON deserialization
    }

    public UserCurationRequest(String curationItems) {
        this.curationItems = curationItems;
    }

    public String getCurationItems() {
        return curationItems;
    }

    public void setCurationItems(String curationItems) {
        this.curationItems = curationItems;
    }
    
}
