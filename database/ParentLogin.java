package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ParentLogin {
    public boolean validate(String username, String password) {
        String query = "SELECT * FROM parents WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
    
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if login is successful
        } catch (Exception e) {
            System.err.println("Error during parent login: " + e.getMessage());
            return false;
        }
    }
}