package jm.task.core.jdbc;

import jm.task.core.jdbc.model.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();


        userService.createUsersTable();
        userService.saveUser("Sasha", "Zadorozhniy", (byte) 25);
        userService.saveUser("Eduard", "Zadorozhniy", (byte) 52);
        userService.saveUser("Dasha", "Handza", (byte) 26);
        userService.saveUser("Vasia", "Table", (byte) 33);
        userService.getAllUsers();
        userService.removeUserById(3);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
