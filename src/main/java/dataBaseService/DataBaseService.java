package dataBaseService;

import browserService.ReadProperties;
import org.apache.log4j.Logger;

import java.sql.*;


public class DataBaseService {
    public static Logger logger = Logger.getLogger(DataBaseService.class);
    public ReadProperties readProperties;

    Connection connection = null;
    Statement statement = null;

    public DataBaseService() {
        readProperties = new ReadProperties();
        final String DB_URL = readProperties.getDB() + "://" + readProperties.getDBHost() + ":" + readProperties.getDBPort() + "/" + readProperties.getDBName();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
            return;
        }

        try {
            connection = DriverManager.getConnection(DB_URL, readProperties.getDBUsername(), readProperties.getDBPassword());
        } catch (SQLException throwables) {
            System.out.println(throwables.toString());
        }

        if (connection != null) {
            System.out.println("You successfully connected to database.");
        } else {
            System.out.println("Что-то пошло не так!");
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
            System.out.println("Не удалось создать Statement...");
        }

        return statement;
    }

    public void executeSQL(String sql) {
        try {
            logger.info("Результат выполнения запроса: " + getStatement().execute(sql));
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void closeStatement() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            System.out.println("Не удалось закрыть Statement");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            System.out.println(throwables.toString());
        }
    }
}
