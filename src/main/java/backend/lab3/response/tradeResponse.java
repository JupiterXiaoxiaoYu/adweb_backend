package backend.lab3.response;

import backend.lab3.mybatis.po.trade;

import java.util.List;

public class tradeResponse {
    private List<trade>  in_record ;
    private List<trade>  out_record ;
    private String message;

    public tradeResponse(List<trade> in_record, List<trade> out_record, String message) {
        this.in_record = in_record;
        this.out_record = out_record;
        this.message = message;
    }

    public List<trade> getIn_record() {
        return in_record;
    }

    public void setIn_record(List<trade> in_record) {
        this.in_record = in_record;
    }

    public List<trade> getOut_record() {
        return out_record;
    }

    public void setOut_record(List<trade> out_record) {
        this.out_record = out_record;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
