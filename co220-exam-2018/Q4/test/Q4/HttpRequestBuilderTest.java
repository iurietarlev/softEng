package Q4;

import static Q1.HttpRequest.Method.POST;
import static Q1.HttpRequestBuilder.anHttpRequest;

import Q1.HttpRequest;
import org.junit.Test;

public class HttpRequestBuilderTest {

  @Test
  public void checkPostRequestUsingBuilder(){
    HttpRequest postRequest = anHttpRequest().withMethod(POST).
        withUrl("http://exams.imperial.ac.uk/575").withBody("mark=100").withHeaders("Date=02-05-2019").build();
  }

}