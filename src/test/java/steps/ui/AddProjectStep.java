package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import models.AddProjectField;
import org.testng.Assert;
import pages.AddProjectPage;
import pages.ProjectsAdministrationPage;


import java.sql.ResultSet;
import java.sql.SQLException;

public class AddProjectStep extends BaseUtil {

    public AddProjectStep(BrowserService browserService) {
        super(browserService);
    }

    @Step("Get project info from db")
    @And("Information about the project in the database, where id = {int}")
    public void getProjectInfoFromDb(int id) {
        browsersService.addProjectField = AddProjectField.builder().build();
        dataBaseService.connectionDataBase();

        try {
            ResultSet resultSet = dataBaseService.executeQuery(sqLqueries.addProjectInformation(id));
            while (resultSet.next()) {
                browsersService.addProjectField.setName(resultSet.getString("name"));
                browsersService.addProjectField.setAnnouncement(resultSet.getString("announcement"));
                browsersService.addProjectField.setTypeOfProject(resultSet.getInt("typeofproject"));
            }
            dataBaseService.closeConnection();
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }

    @Step("Project was created")
    @Then("The project was created")
    public void textIsDisplayed() {
        AddProjectPage addProjectPage = new AddProjectPage(browsersService);
        addProjectPage.getNameField(browsersService.addProjectField.getName());
        addProjectPage.getAnnouncementField(browsersService.addProjectField.getAnnouncement());
        addProjectPage.click(0);
        addProjectPage.getAddProjectButton().submit();
    }

    @Step ("Expected text is displayed")
    @Then("Text {string} is displayed")
    public void textIsDisplayed(String text) {
        Assert.assertEquals(new ProjectsAdministrationPage(browsersService).getProjectAddedMessage(),
                text,
                "Project was NOT added");
    }

    @Step("Add project with empty name")
    @And("User leave field 'Name' empty and clicks Add Project button in the bottom of the page")
    public void addProjectButtonInTheBottomOfThePage() {
        AddProjectPage addProjectPage = new AddProjectPage(browsersService);
        addProjectPage.getAddProjectButton().submit();

    }

    @Step("Click Add Project button")
    @And("User clicks Add Project button in the bottom of the page")
    public void addProject() {
        AddProjectPage addProjectPage = new AddProjectPage(browsersService);
        addProjectPage.getNameField(browsersService.addProjectField.getName());
        addProjectPage.getAddProjectButton().submit();
    }

    @Step("Project was not created")
    @Then("The project was not created")
    public void projectNotCreated() {
        Assert.assertEquals(new AddProjectPage(browsersService).getRequiredText().getText(),
                "Field Name is a required field.",
                "Project was NOT added");
    }

    @Step("Check the project name length")
    @Then("The last value is cropped and the project name has {int} characters")
    public void theLastValueIsCroppedAndTheProjectNameHasCharacters(int characters) {
        Assert.assertEquals(new ProjectsAdministrationPage(browsersService).getCurrentProject().length(), characters);
    }
}
