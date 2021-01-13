package steps.api;

import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.ProjectGSON;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import browserService.ReadProperties;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiStep extends BaseApiStep {
    public ReadProperties properties;
    private String endpoint;
    private String currentUser;
    private static Response response;
    private int status;
    private String userName;
    private int projectId = 0;

    @Step("Connect to API")
    @Given("api is set up")
    public void apiIsSetUp() {
        properties = new ReadProperties();

        RestAssured.baseURI = properties.getApiURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(properties.getUsername(), properties.getPassword());
    }

    @Step("Get the list of projects (API)")
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

    @Step("Get the current user (API)")
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

    @Step("Get all active projects (API)")
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

    @Step("Create a project (API)")
    @When("admin creates a project")
    public void createProject() {
        String endpoint = "index.php?/api/v2/add_project";
        ProjectGSON project = ProjectGSON.builder()
                .name("API Test")
                .suite_mode(1)
                .build();

        Gson gson = new Gson();
        String json = gson.toJson(project);

        this.projectId =
                given()
                        .body(json)
                        .when()
                        .post(endpoint)
                        .then()
                        .log().body()
                        .body("name", equalTo("API Test"))
                        .body("suite_mode", is(1))
                        .body("show_announcement", is(false))
                        .body("is_completed", is(false))
                        .statusCode(HttpStatus.SC_OK)
                        .extract().jsonPath().get("id");
    }

    @Step ("Get the project (API)")
    @And("admin gets the project")
    public void getProject() {
        String endpoint = "index.php?/api/v2/get_project/{id}";
        given()
                .when()
                .pathParam("id", projectId)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Step ("Get the status code (API)")
    @Then("status code is {int}")
    public void statusCodeIs(int statusCode) {
        Assert.assertEquals(status, statusCode, "Something went wrong");
    }

    @Step ("Check user name (API)")
    @Then("user name equals to {string}")
    public void getCurrentUser(String currentUser) {
        Assert.assertEquals(userName, currentUser, "User name is incorrect");
    }

    @Step ("Delete the project")
    @Then("admin deletes this project")
    public void deleteProject() {
        String endpoint = "index.php?/api/v2/delete_project/{id}";
        given()
                .pathParam("id", projectId)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}

