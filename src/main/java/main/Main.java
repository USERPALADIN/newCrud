package main;

import database.DatabaseSource;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseSource database = new DatabaseSource();
        try {
       //    database.addNewUser(new User(3, "Artem", "Artems", "4321"));
         //   database.deleteUser("Dimas");
       //     database.updateUser(new User(2, "Anton", "antonio", "333"));
            database.getAllUsers().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
