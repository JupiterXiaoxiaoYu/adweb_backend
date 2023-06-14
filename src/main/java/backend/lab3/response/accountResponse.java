package backend.lab3.response;
import  backend.lab3.mybatis.po.account;
public class accountResponse {
    private account account;
    private String message;

    public accountResponse(backend.lab3.mybatis.po.account account, String message) {
        this.account = account;
        this.message = message;
    }
}
