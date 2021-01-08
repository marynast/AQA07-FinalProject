package dataBaseService;

import browserService.ReadProperties;
import org.testng.log4testng.Logger;

import java.sql.*;


public class DataBaseService {
    public static org.testng.log4testng.Logger logger = Logger.getLogger(DataBaseService.class);
    private static Connection connection = null;
    private static Statement statement = null;
    public ReadProperties properties;


    public DataBaseService() {
        properties = new ReadProperties();
    }

    public void connectionDataBase() {
        logger.error("Setup JDBC connector");
        String db_URL = properties.getDB() + "://" + properties.getDBHost() + ":" + properties.getDBPort() + "/" + properties.getDBName();
        try {
            Class.forName("org.postgresql.Driver");
            logger.trace("Class has been found");
            connection = DriverManager.getConnection(db_URL, properties.getDBUsername(), properties.getDBPassword());
            logger.info("Connection has been established");
            logger.info("Setup statement");
            statement = connection.createStatement();
            logger.info("Statement has been created");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error(e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return resultSet;
    }


    public void closeConnection() {
        try {
            if (!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }
}
