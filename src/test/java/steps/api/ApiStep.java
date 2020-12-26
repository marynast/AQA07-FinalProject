package steps.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import utils.ReadProperties;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class ApiStep {
    public ReadProperties properties;
    private String endpoint;
    private String currentUser;
    private static Response response;

    @Step
    @Given("api is set up")
    public void apiIsSetUp() {
        properties = new ReadProperties();

        RestAssured.baseURI = properties.getApiURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(properties.getUsername(), properties.getPassword());
    }

    @Step
    @When("admin sends GET request to {string}")
    public void adminSendsGETRequestTo(String endpoint) {
        this.endpoint = endpoint;
        given()
                .when().get(endpoint);
    }

    @Step
    @Then("status code is {int}")
    public void statusCodeIs(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Invalid Status Code");
    }

    @Step
    @Then("user name equals to {string}")
    public void getCurrentUser(String currentUser) {

    }
}

