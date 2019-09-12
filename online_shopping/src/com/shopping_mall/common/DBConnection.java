package com.shopping_mall.common;
import java.sql.*;

public class DBConnection {
    // JDBC driver name and database URL
    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/shop";

    // Database credentials
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "******";

    static Connection dbConnection = null;

    public static PreparedStatement prepare(String stm) throws SQLException{
        PreparedStatement preparedStatement = null;
        try{
            Connection dbConnection = getDBConnection();

            preparedStatement = dbConnection.prepareStatement(stm);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return preparedStatement;
    }

    private static Connection getDBConnection(){
        try{
            // Register JDBC driver
            DriverManager.registerDriver(new org.postgresql.Driver());

            //Open a connection
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            dbConnection.setAutoCommit(false);

            return dbConnection;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Connection problem");
        return null;
    }
}
