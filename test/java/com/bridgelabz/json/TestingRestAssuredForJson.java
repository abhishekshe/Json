package com.bridgelabz.json;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestingRestAssuredForJson {
    @Test(priority = 0)
    public void postRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"title\": \"json-server\",\n" +
                        "    \"author\": \"typicode\"\n" +
                        "  }\n" +
                        "]")
                .queryParam("position", 3)
                .when()
                .post("http://localhost:3000/posts");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }
    @Test(priority = 1)
    public void getRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test(priority = 2)
    public void putRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"title\": \"json-server\",\n" +
                        "    \"author\": \"Abhishek\"\n" +
                        "  },\n" +
                        "  [\n" +
                        "    {\n" +
                        "      \"id\": 2,\n" +
                        "      \"title\": \"json-server\",\n" +
                        "      \"author\": \"Abhishek\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "]")
                .when()
                .put("http://localhost:3000/posts/2");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test(priority = 3)
    public void postRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"body\": \"Comment\",\n" +
                        "    \"postId\": 1\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("http://localhost:3000/comments");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test(priority = 4)
    public void getRequestForComments() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/comments");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 5)
    public void putRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"body\": \"Abhishek\",\n" +
                        "        \"postId\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"body\": \"Abhishek\",\n" +
                        "        \"postId\": 1\n" +
                        "    }\n" +
                        "]")
                .when()
                .put("http://localhost:3000/comments/2");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test(priority = 6)
    public void postRequestForProfile() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\" : 1,\n" +
                        "    \"name\": \"Abhishek Narwariya\",\n" +
                        "    \"Address\" : \"Bhopal\",\n" +
                        "    \"Email\" : \"abhishek123@gmail.com\"\n" +
                        "\n" +
                        "}")
                .when()
                .post("http://localhost:3000/profile");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test(priority = 7)
    public void getRequestForProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(" http://localhost:3000/profile");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
