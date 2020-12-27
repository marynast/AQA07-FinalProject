package browserService;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    protected Properties properties;

    public ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURL() {
        return properties.getProperty("URL");
    }

    public String getBrowserName() {
        return properties.getProperty("browserType");
    }

    public boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("psw");
    }

    public String getApiURL() {
        return properties.getProperty("apiURL");
    }

    public String getDB() {
        return properties.getProperty("db");
    }

    public String getDBName() {
        return properties.getProperty("dbName");
    }

    public String getDBHost() {
        return properties.getProperty("dbHost");
    }

    public String getDBPort() {
        return properties.getProperty("dbPort");
    }

    public String getDBUsername() {
        return properties.getProperty("dbUsername");
    }

    public String getDBPassword() {
        return properties.getProperty("dbPassword");
    }
}
