import dataBaseService.DataBaseService;
import org.testng.annotations.Test;

public class test {

    @Test
    public void test (){
        DataBaseService dataBaseService = new DataBaseService();
       dataBaseService.closeConnection();

    }
}
