package Senarios;

import Pojo.user_Valid.create_list_of_users;
import Pojo.user_Valid.updated_user;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class user_with_Data_is_incomplete {


    String username;
    String password;


    @Test
    public void req_1() {



        //  Build Pet Object
        create_list_of_users users = new create_list_of_users();
        users.setId(10);
        users.setUsername("Adel");
        users.setFirstName("string");
        users.setLastName("string");
        users.setEmail("string");
        users.setPassword("string");
        users.setPhone("string");
        users.setUserStatus(0);


        //  Headers
        Headers headers = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("accept", "application/json"));

        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .body(users)
                .log().all()
                .when()
                .post("/user/createWithList")
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L));
    }


    @Test
    public void req_2() {


        //  Headers
        Headers headers = new Headers(
                new Header("accept", "application/json"));

        //  Send Request
        Response response =
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .log().all()
                .when()
                .get("/user/Adel")
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L))
                .extract().response();
                username = response.path("username");
                password = response.path("password");
                System.out.println(username);

    }



    @Test(dependsOnMethods = "req_2")
    public void req_3() {



        //  Build Pet Object
        updated_user users = new updated_user();
        users.setUsername("Adel");
        users.setFirstName("string");
        users.setLastName("string");
        users.setEmail("string");
        users.setPassword("string");


        //  Headers
        Headers headers = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("accept", "application/json"));

        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .body(users)
                .log().all()
                .when()
                .put("/user/"+username)
                .then()
                .log().all()
                .statusCode(404)
                .statusLine(containsString("Not Found"))
                .time(lessThan(10000L));
    }


    @Test(dependsOnMethods = "req_2")
    public void req_4() {


        //  Headers
        Headers headers = new Headers(
                new Header("accept", "application/json"));

        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .log().all()
                .when()
                .delete("/user/"+username)
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L));

    }


    @Test(dependsOnMethods = "req_2")
    public void req_5() {


        //  Headers
        Headers headers = new Headers(
                new Header("accept", "application/json"));
        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .log().all()
                .when()
                .get("/user/login?"+username+"&"+password)
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L));
    }



    @Test
    public void req_6() {


        //  Headers
        Headers headers = new Headers(
                new Header("accept", "application/json"));

        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .log().all()
                .when()
                .get("/user/logout")
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L));

    }


}