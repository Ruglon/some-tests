package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static config.ConfigReader.baseConfig;

public class BaseApiClass {

    public static String getUrl = baseConfig.urlApi();

    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(getUrl)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSpecToSendFile(){
        return new RequestSpecBuilder()
                .setBaseUri(getUrl)
                .setContentType(ContentType.MULTIPART)
                .build();
    }
}
