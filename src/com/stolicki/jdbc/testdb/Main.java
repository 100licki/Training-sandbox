package com.stolicki.jdbc.testdb;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\karol\\..Intellij Projects\\" +
            "zadania_rekrutacyjne_sandbox\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";


    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE  IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + " TEXT, " + COLUMN_PHONE + " INTEGER, " + COLUMN_EMAIL + " TEXT)");

            insertContact(statement, "Karol", 123321123, "karol@email.com");
            insertContact(statement, "Kenny", 123456789, "kenny@email.com");
            insertContact(statement, "John", 987654321, "john@email.com");
            insertContact(statement, "Danny", 321321321, "danny@email.com");
            insertContact(statement, "Charlie", 987987987, "charlie@email.com");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " + COLUMN_PHONE + "=555555555" +
                    " WHERE " + COLUMN_NAME + "='Karol'");

            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                    " WHERE " + COLUMN_NAME + "='Charlie'");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(COLUMN_NAME) + " " +
                        resultSet.getInt(COLUMN_PHONE) + " " +
                        resultSet.getString(COLUMN_EMAIL));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL + ")" +
                " VALUES ('" + name + "', " + phone + ", '" + email + "')");
    }
}
