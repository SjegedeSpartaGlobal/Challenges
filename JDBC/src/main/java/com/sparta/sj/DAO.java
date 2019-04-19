package com.sparta.sj;

import java.sql.*;

public class DAO {
    private final String QUERY = "select e.first_name , e.salary from employees e where e.employee_id = ?";
    private final String QUERY_ID = "select e.last_name, e.salary from employees e where e.salary > ?";
    private final String MY_SQL = "jdbc:mysql://localhost:3306/hr?user=root&password=1992Megamind&useSSL=false";
    private Connection connection;

    public void basicSQLQuery(String id) {
        try {
            connection = DriverManager.getConnection(MY_SQL);
            PreparedStatement statement = connection.prepareStatement(QUERY);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Name is " + resultSet.getString(1));
                System.out.println("Salary is " + resultSet.getInt(2));
            }
            System.out.println("Hello");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

