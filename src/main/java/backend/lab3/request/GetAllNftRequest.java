package backend.lab3.request;

public class GetAllNftRequest {
    private String keywords;
    private String status;
    private String owner;


    public GetAllNftRequest(String keywords, String status, String owner) {
        this.keywords = keywords;
        this.status = status;
        this.owner = owner;
    }

    public String getNftStatus() {
        return status;
    }

    public void setNftStatus(String status) {
        this.status = status;
    }

    public String getNftOwner() {
        return owner;
    }

    public void setNftOwner(String owner) {
        this.owner = owner;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


}
