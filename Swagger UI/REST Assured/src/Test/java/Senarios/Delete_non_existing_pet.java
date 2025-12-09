package Senarios;


import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class Delete_non_existing_pet {



    @Test
    public void req_1() {


        //  Headers
        Headers headers = new Headers(
                new Header("accept", "application/json"));

        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .log().all()
                .when()
                .delete("/pet")
                .then()
                .log().all()
                .statusCode(405)
                .statusLine(containsString("Method Not Allowed"))
                .time(lessThan(10000L));

    }
}