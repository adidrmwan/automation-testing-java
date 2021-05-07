package test.bukalapak.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class Posts {
    public static String baseUri = "https://jsonplaceholder.typicode.com";

    @Test
    public void verifyPostsSchema() {
        File schema = new File(System.getProperty("user.dir") + "/src/test/java/test/bukalapak/rest/schema/PostsSchema.json");
        RestAssured.given()
                .baseUri(baseUri)
                .when()
                .get("/posts")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body(matchesJsonSchema(schema));
    }

    @Test
    public void verifyPostData() {
        Map<String, Object> body = new HashMap<>();

        body.put("title", "recomendation");
        body.put("body", "motorcycle");
        body.put("userId", 12);

        body.values().removeAll(Collections.singleton(null));

        RestAssured.given().
                when()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(body)
                .post("/posts")
                .then()
                .assertThat()
                .statusCode(201)
                .and()
                .body("title", equalToIgnoringCase("recomendation"))
                .body("body", equalToIgnoringCase("motorcycle"))
                .body("userId", equalTo(12));
    }
}
