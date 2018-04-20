package main;

import service.HibernateService;
import service.UserService;
import table.User;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        //  userService.addNewUser(new User( "Dimaasd", "Zxcxzcx", "456713"));
        // userService.addNewUser(new User("3","Artem", "Artems", "1234"));
        //   userService.deleteUser("3");
        //     userService.updateUser(new User(2, "Anton", "antonio", "333"));
        //  userService.getAllUsers().forEach(System.out::println);
//      User user  =   userService.getUserById(14);
//        System.out.println(user.getName());
        User user = new User("fgg", "Lasdar", "003");

        HibernateService hibernateService = new HibernateService();
        hibernateService.printConnectInfo();
        hibernateService.addUser(user);
        User user1 =  hibernateService.getUserById(1);
        System.out.println(user1.getName() + " " +
                user1.getLogin() + " " +
                user1.getPassword());
        hibernateService.deleteUser(1);
        System.out.println(user1.getName() + " " +
                user1.getLogin() + " " +
                user1.getPassword());
    }
}
