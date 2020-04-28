package Q1;

import static Q1.HttpRequest.Method;
import static Q1.HttpRequest.Method.POST;
import static Q1.HttpRequestBuilder.anHttpRequest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HttpRequestBuilderTest {

  @Test
  public void checkPostRequestUsingBuilder(){
    String body = "mark=100";
    String url = "http://exams.imperial.ac.uk/575";
    String header = "Date=02-05-2019";
    Method method = POST;

    HttpRequest postRequest = anHttpRequest().withMethod(method).
        withUrl(url).withBody(body).withHeaders(header).build();

    assertEquals(postRequest.body, body);
    assertEquals(postRequest.url, url);
    assertEquals(postRequest.headers.get(0), header );
    assertEquals(postRequest.method, method);
  }

}