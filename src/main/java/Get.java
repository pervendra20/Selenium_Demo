import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class   Get {
    @Test
    public void findPet() {

        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        // RequestSpecification httpRequest =RestAssured.given() ;//or
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("/111");
        System.out.println("Ammmmmmmm"+response.asString());
//{"id":11,"category":{"id":0,"name":"Schmidt"},"name":"Polly","photoUrls":["string"],"tags":[{"id":0,"name":"string"}],"status":"sold"}
        int statusCode = response.getStatusCode();
        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/,
                "Correct status code returned");
        JsonPath path=response.jsonPath();
        String name= path.get("tags[0].name");
        Integer id= path.get("tags[0].id");
        // String name= path.get("category.id");
        System.out.println("name1111-----------"+name);
        System.out.println("id1111-----------"+id);

        JsonPath path1=response.jsonPath();
        Integer id1= path1.get("id");
        System.out.println("id2222---"+id1);
    }
// before get ->please post

    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());


        Response response2=given().contentType(ContentType.JSON)
                .when().get("https://demoqa.com/BookStore/v1/Books");
        System.out.println("aaaaaaaa"+response2.asString());
//////////////////////////////////////////////////////////////////////////

        RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
        Response response3=given().contentType(ContentType.JSON)
                .when().get();
        System.out.println("bbbbbbbb"+response3.asString());

    }

    @Test
    public void GetBookHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
// Access header with a given name.
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
// Access header with a given name.
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
// Access header with a given name. Header = Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
    }

    @Test
    public void GetALLreqres() {

        RestAssured.baseURI = "https://reqres.in/api/users?page=187";
        Response response=given().contentType(ContentType.JSON)
                .when().get();
        System.out.println("bbbbbbbb"+response.asString());

    }
    @Test
    public void pathParamFun() {

        Response res=  given().contentType(ContentType.JSON).
                when().pathParam("myparam","/11").
                get("https://petstore.swagger.io/v2/pet/{myparam}").
                then().extract().response();
        System.out.println("resresresres11"+res.asString());

    }
    @Test
    public void Queryreqres() {
//"https://reqres.in/api/users?page=2";

        RestAssured.baseURI = "https://reqres.in/api/users";//?page=2";

        Response response=given().contentType(ContentType.JSON).queryParam("page",988)
                .when().get();
        System.out.println("bbbbbbbb"+response.asString());


        //or


        Response response1=given().contentType(ContentType.JSON).queryParam("page",2)
                .when().get("https://reqres.in/api/users");
        System.out.println("ccccccc"+response1.asString());

    }


    @Test
    public void Getreqres() {
//        {
//            "name": "aaaaa",
//            "job": "AAAA",
//            "id": "249",
//            "createdAt": "2023-09-04T10:53:36.615Z"
//        }

        RestAssured.baseURI = "https://reqres.in/api/users/2";
        Response response=given().contentType(ContentType.JSON)
                .when().get();
        System.out.println("bbbbbbbb"+response.prettyPrint());
    }

    @Test
    public void myURI() {
        RestAssured.baseURI = "https://api.github.com/users/zellwk/repos";
        Response res = given().contentType(ContentType.JSON).when().get();
        int responseCode = res.getStatusCode();
        System.out.println("Response code" + responseCode);
        long resTime =  res.getTime();
        System.out.println(resTime);
    }
}