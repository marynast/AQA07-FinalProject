package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import pages.ProjectsAdministrationPage;

public class AdministrationPageStep extends BaseUtil {

    public AdministrationPageStep(BrowserService browserService) {
        super(browserService);
    }

    @And("Administration page is opened and user click button Dashboard")
    public void admistrationPageIsOpened() {
        ProjectsAdministrationPage projectsAdministrationPage = new ProjectsAdministrationPage(browsersService);
        projectsAdministrationPage.getDashboard().click();

    }

}
