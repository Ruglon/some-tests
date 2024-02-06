package api;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static config.ConfigReader.testConfig;
import static io.restassured.RestAssured.given;

public class GetUsersList {

    public static RequestSpecification requestSpecification = BaseApiClass.requestSpec();
    public static String users = testConfig.users();


    public ValidatableResponse getUsersList(String page){
        return given()
                .spec(requestSpecification)
                .param("page", page)
                .contentType(ContentType.JSON)
                .when()
                .get(users)
                .then()
                .log().all();
    }

    public ValidatableResponse getUserByID(String userId){
        return given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .when()
                .get(users + "/" + userId)
                .then()
                .log().all();
    }
}
