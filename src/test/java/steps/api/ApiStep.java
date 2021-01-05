package steps.api;

import baseEntities.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import browserService.ReadProperties;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ApiStep {
    public ReadProperties properties;
    private String endpoint;
    private String currentUser;
    private static Response response;
    private int status;
    private String userName;

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
    @When("admin sends GET request to get the list of Projects")
    public void adminSendsGETRequest() {
        String endpoint = "/index.php?/api/v2/get_projects";
        this.status =
                given()
                        .when()
                        .get(endpoint)
                        .then()
                        .log().body()
                        .extract().response().getStatusCode();
    }

    @Step
    @When("admin sends GET request to get the current user")
    public void adminSendsGETRequestTo() {
        String endpoint = "/index.php?/api/v2/get_current_user";
        this.userName =
                given()
                        .when()
                        .get(endpoint)
                        .then()
                        .log().body()
                        .extract().jsonPath().get("name");
    }

    @Step
    @When("admin sends GET request to get all active projects")
    public void adminSendsGETRequestToGetAllActiveProjects() {
        String endpoint = "/index.php?/api/v2/get_projects&is_completed=0";
        this.status =
                given()
                        .when()
                        .get(endpoint)
                        .then()
                        .log().body()
                        .extract().response().getStatusCode();
    }

    @Step
    @Then("status code is {int}")
    public void statusCodeIs(int statusCode) {
        Assert.assertEquals(status, statusCode, "Something went wrong");
    }

    @Step
    @Then("user name equals to {string}")
    public void getCurrentUser(String currentUser) {
        Assert.assertEquals(userName, currentUser, "User name is incorrect");
    }
}

