package com.shopping_mall.common;
import java.sql.*;

public class DBConnection {
    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    //static final String DB_URL = "jdbc:postgresql://ec2-50-17-194-129.compute-1.amazonaws.com:5432/d8ai6gphpuhcgm?sslmode=require";
    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/shop";

    // Database credentials
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "APTX4869";

    static Connection dbConnection = null;

    public static PreparedStatement prepare(String stm) {
        PreparedStatement preparedStatement = null;
        try {
            if (dbConnection == null) {
                dbConnection = getDBConnection();
            }
            System.out.println(stm);
            preparedStatement = dbConnection.prepareStatement(stm);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return preparedStatement;
    }

    public static void close(PreparedStatement preparedStatement) {
        Connection dbConnection;
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Connection getDBConnection() {
        Connection conn = null;
        try {
            // register driver
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            System.out.println("Connect database...");
            return conn;
        } catch (SQLException se){
            // process JDBC error
            se.printStackTrace();
        } catch (Exception e){
            // process Class.forName error
            e.printStackTrace();
        }
        return null;
    }


    public static PreparedStatement prepare(String stm, int returnGenerateKeys){

        PreparedStatement preparedStatement = null;
        try{
            Connection dbConnection = getDBConnection();

            preparedStatement = dbConnection.prepareStatement(stm, Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return preparedStatement;
    }
}
