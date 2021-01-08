package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.AddProjectField;
import org.testng.Assert;
import pages.AddProjectPage;
import pages.ProjectsAdministrationPage;
import support.MyWebDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddProjectStep extends BaseUtil {

    public AddProjectStep(BrowserService browserService) {
        super(browserService);
    }


    @And("Information about the project in the database, where id = {int}")
    public void getProjectInfoFromDb ( int id) {
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

    @Then("The project was created")
    public void textIsDisplayed(String expectedText) {
        Assert.assertEquals(new ProjectsAdministrationPage(browsersService).getProjectAddedMessage(),
                expectedText,
                "Project was NOT added");
    }
}
