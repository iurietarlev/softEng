package Q1;

import java.util.ArrayList;
import java.util.List;

public class HttpRequest {

    public enum Method {
        GET,
        PUT,
        POST,
        HEAD,
        DELETE
    }

    public String url;
    public String body;
    public ArrayList<String> params;
    public Method method;
    public ArrayList<String> headers;

    // more code here - not relevant for exam question
}

