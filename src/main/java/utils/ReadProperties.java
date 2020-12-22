package utils;

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

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("psw");
    }
}
