package Senarios;

import Pojo.pet_valid.add_new_pet;
import Pojo.pet_valid.category_pojo;
import Pojo.pet_valid.tags_pojo;
import Pojo.pet_valid.update_existing_pet_pojo;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class pet_valid {


    int id;
    @Test
    public void req_1() {

        //  Build Category
        category_pojo category = new category_pojo();
        category.setId(0);
        category.setName("string");

        //  Build photoUrls as List
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");

        //  Build tags as List
        tags_pojo tag = new tags_pojo();
        tag.setId(20);
        tag.setName("string");

        List<tags_pojo> tagsList = new ArrayList<>();
        tagsList.add(tag);

        //  Build Pet Object
        add_new_pet pet = new add_new_pet();
        pet.setId(10);
        pet.setCategory(category);
        pet.setName("doggie");
        pet.setPhotoUrls(photoUrls);
        pet.setTags(tagsList);
        pet.setStatus("available");

        //  Headers
        Headers headers = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("accept", "application/json"));

        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .body(pet)
                .log().all()
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L));





    }

    @Test
    public void req_2() {

        //  Build Category
        category_pojo category = new category_pojo();
        category.setId(0);
        category.setName("string");

        //  Build photoUrls as List
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");

        //  Build tags as List
        tags_pojo tag = new tags_pojo();
        tag.setId(20);
        tag.setName("string");

        List<tags_pojo> tagsList = new ArrayList<>();
        tagsList.add(tag);

        //  Build update_existing_pet Object
        update_existing_pet_pojo update_existing_pet_pojo = new update_existing_pet_pojo();
        update_existing_pet_pojo.setId(10);
        update_existing_pet_pojo.setCategory(category);
        update_existing_pet_pojo.setName("doggie");
        update_existing_pet_pojo.setPhotoUrls(photoUrls);
        update_existing_pet_pojo.setTags(tagsList);
        update_existing_pet_pojo.setStatus("available");

        //  Headers
        Headers headers = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("accept", "application/json"));

        //  Send Request
        Response response=
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .body(update_existing_pet_pojo)
                .log().all()
                .when()
                .put("/pet")
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L))
                .extract().response();
                id = response.path("id");
                System.out.println(id);



    }

    @Test
    public void req_3() {


        //  Headers
        Headers headers = new Headers(
                new Header("accept", "application/json"));

        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .param("status","available")
                .log().all()
                .when()
                .get("/pet/findByStatus")
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
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
                .get("/pet/"+id)
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
                new Header("Content-Type", "application/x-www-form-urlencoded"),
                new Header("accept", "application/json"));

        //  Send Request
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .headers(headers)
                .formParam("name", "kangs name")
                .log().all()
                .when()
                .post("/pet/"+id)
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L));

    }

    @Test(dependsOnMethods = "req_2")
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
                .delete("/pet/"+id)
                .then()
                .log().all()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .time(lessThan(10000L));

    }
}