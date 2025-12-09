package Senarios;

import Pojo.store_valid.place_an_order_for_pet_pojo;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;


public class store_without_token_Invalid {

    int id;



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
                .get("/store/inventory")
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L));

    }


    @Test
    public void req_2() {

        //  Build store Object
        place_an_order_for_pet_pojo store = new place_an_order_for_pet_pojo();
        store.setId(10);
        store.setPetId(50);
        store.setQuantity(0);
        store.setShipDate("2025-11-20T12:09:15.110Z");;
        store.setStatus("placed");
        store.setComplete(true);


        //  Headers
        Headers headers = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("accept", "application/json"));

        //  Send Request

                given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .body(store)
                .log().all()
                .when()
                .post("/store/order")
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L));

    }


    @Test(dependsOnMethods = "req_2")
    public void req_3() {

        //  Headers
        Headers headers = new Headers(
                new Header("accept", "application/json"));


        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .log().all()
                .when()
                .get("/store/order/")
                .then()
                .log().all()
                .statusCode(405)
                .statusLine(containsString("Method Not Allowed"))
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
                .delete("/store/order/")
                .then()
                .log().all()
                .statusCode(405)
                .statusLine(containsString("Method Not Allowed"))
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
                .get("/store/order/")
                .then()
                .log().all()
                .statusCode(405)
                .statusLine(containsString("Method Not Allowed"))
                .time(lessThan(10000L));
    }

}