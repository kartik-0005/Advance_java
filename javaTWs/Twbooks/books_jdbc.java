package Twbooks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class books_jdbc {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/booksdb";
        String username = "root";
        String password = "Tanuvinnu@1234";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter author name: ");
        String author_n = sc.nextLine();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "Select book_name, author_name FROM BOOKS where author_name = ? ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,author_n);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String book_name = resultSet.getString("book_name");
                        String author_name = resultSet.getString("author_name");

                        System.out.println("Book: " + book_name+ ", Author: " + author_name);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
}