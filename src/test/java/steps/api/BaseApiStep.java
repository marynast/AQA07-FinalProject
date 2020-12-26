package steps.api;

import io.cucumber.java.BeforeStep;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import utils.ReadProperties;

import static io.restassured.RestAssured.given;

public abstract class BaseApiStep {
    public ReadProperties properties;

    @BeforeTest
    @Step
    public void setUp() {
        properties = new ReadProperties();

        RestAssured.baseURI = properties.getApiURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(properties.getUsername(), properties.getPassword());
    }
}