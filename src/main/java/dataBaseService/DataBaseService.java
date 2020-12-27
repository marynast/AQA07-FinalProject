package dataBaseService;

import browserService.ReadProperties;
import org.apache.log4j.Logger;

import java.sql.*;

public class DataBaseService {
    public static Logger logger = Logger.getLogger(DataBaseService.class);
    Connection connection = null;
    Statement statement = null;
    public ReadProperties properties;

    public DataBaseService() {
        properties = new ReadProperties();
        String DB_URL = properties.getDB() + "://" + properties.getDBHost() + ":" + properties.getDBPort() + "/" + properties.getDBName();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.info(e.toString());
            return;
        }
        try{
            connection = DriverManager.getConnection(DB_URL, properties.getDBUsername(), properties.getDBPassword());
        } catch (SQLException throwables) {
            logger.info(throwables.toString());
        }

        if(connection != null) {
            logger.info("Connection to DB is successful");
        } else {
            logger.info("Something went wrong");
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Statement getStatement() {
        try {
            if (statement == null) {
                statement = getConnection().createStatement();
            }
        } catch (SQLException ex) {
            logger.info("Couldn't create statement");
        }
        return statement;
    }

    public void executeSQL(String sql) {
        try {
            logger.info("Request result: " + getStatement().execute(sql));
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }
        return null;
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
