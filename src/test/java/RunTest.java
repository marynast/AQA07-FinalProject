import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class RunTest extends AbstractTestNGCucumberTests {

    @Override
    @Parameters("browserType")
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
