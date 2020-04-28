package Q1;

import java.util.ArrayList;
import java.util.Arrays;

public class HttpRequestBuilder {
  private String url = null;
  private String body = null;
  private ArrayList<String> params = new ArrayList<>();
  private HttpRequest.Method method = null;
  private ArrayList<String> headers = new ArrayList<>();

  private HttpRequestBuilder() {}

  public static HttpRequestBuilder anHttpRequest() {
    return new HttpRequestBuilder();
  }

  public HttpRequest build() {
    HttpRequest httpRequest = new HttpRequest();
    httpRequest.url = this.url;
    httpRequest.body = this.body;
    httpRequest.params = this.params;
    httpRequest.method = this.method;
    httpRequest.headers = this.headers;
    return httpRequest;
  }

  public HttpRequestBuilder withUrl(String url) {
    this.url = url;
    return this;
  }

  public HttpRequestBuilder withBody(String body) {
    this.body = body;
    return this;
  }

  public HttpRequestBuilder withParams(String param) {
    this.params.add(param);
    return this;
  }

  public HttpRequestBuilder withMethod(HttpRequest.Method method) {
    this.method = method;
    return this;
  }

  public HttpRequestBuilder withHeaders(String header) {
    this.headers.add(header);
    return this;
  }
}
