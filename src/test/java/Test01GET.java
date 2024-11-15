import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;



public class Test01GET {


@Test
    void test_01() {

    Response response = RestAssured.get("https://reqres.in/api/users?page=2");

    System.out.println(response.asString());
    System.out.println(response.getBody().asString());
    System.out.println(response.getStatusCode());
    System.out.println(response.getStatusLine());
    System.out.println(response.getTime());
    }
}
