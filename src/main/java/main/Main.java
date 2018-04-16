package main;

import database.DatabaseSource;
import tables.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseSource database = new DatabaseSource();
        try {
     //    database.addNewUser(new User("4", "Dima", "Zxc", "4567"));
    // database.addNewUser(new User("3","Artem", "Artems", "1234"));
         //   database.deleteUser("3");
       //     database.updateUser(new User(2, "Anton", "antonio", "333"));
      database.getAllUsers().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
