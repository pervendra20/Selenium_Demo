import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostApi {


    @Test
    public void PostreqresSpec() {

        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification httpRequest = given();
        Response response1=httpRequest.contentType(ContentType.JSON).body("{\n" +
                        "    \"name\": \"amit\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post();
        System.out.println("ccccccc"+response1.prettyPrint());
        String contentType = response1.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);

    }


    @Test
    public void Postreqres() {

        RestAssured.baseURI = "https://reqres.in/api/users";
        Response response1=given().contentType(ContentType.JSON).body("{\n" +
                        "    \"name\": \"amit\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post();
        System.out.println("ccccccc"+response1.prettyPrint());


        String contentType = response1.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);

    }


    @Test
    public void PostreqMap() {

        RestAssured.baseURI = "https://reqres.in/api/users";

        Map<String,String> map= new HashMap<>();
        map.put("name","aaaaa");
        map.put("job","AAAA");

        Response response=given().contentType(ContentType.JSON).body(map)
                .when().post();
        System.out.println("ccccccc"+response.prettyPrint());

    }

    @Test
    public void PostreqJsonObject() {

        RestAssured.baseURI = "https://reqres.in/api/users";

//        JsonObject  jsonObject= new JsonObject();
//        jsonObject.add("name","aaaaa");
//        jsonObject.add("job","AAAA");
//
////        Response response=given().contentType(ContentType.JSON).body(map)
//                .when().post();
//        System.out.println("ccccccc"+response.prettyPrint());

    }

    @Test
    public void Putreq() {

        RestAssured.baseURI = "https://reqres.in/api/users/187";
        Response response=given().contentType(ContentType.JSON).body("{\n" +
                        "    \"name\": \"amitGoyal\",\n" +
                        "    \"job\": \"leaderPut\"\n" +
                        "}")
                .when().put();
        System.out.println("ccccccc"+response.prettyPrint());

    }

    @Test
    public void Patchreq() {

        RestAssured.baseURI = "https://reqres.in/api/users/187";
        Response response=given().contentType(ContentType.JSON).body("{\n" +
                        "    \"name\": \"amitGoyal\",\n" +
                        "    \"job\": \"leaderPatch\"\n" +
                        "}")
                .when().patch();
        System.out.println("ccccccc"+response.prettyPrint());

    }
    @Test
    public void Postreq() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        Response response=given().contentType(ContentType.JSON).body("{\"id\":111,\"category\":{\"id\":0,\"name\":\"Schmidt\"},\"name\":\"Polly\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],\"status\":\"sold\"}\n" +
                "  ")  .when().post();
    }
}
