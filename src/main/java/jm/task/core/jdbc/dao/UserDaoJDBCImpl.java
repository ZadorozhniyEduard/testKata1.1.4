package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {    // создаем таблицу
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "    id bigint primary key auto_increment," +
                    "    name varchar(255)," +
                    "    lastName varchar(255)," +
                    "    age tinyint unsigned" +
                    ");");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {   // удаляем таблицу
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.execute("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {    // создаем юзеров
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate("INSERT users(name, lastName, age) VALUES ('" +
                    name + "', '"+ lastName +"', "+ age +")");
//            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM users WHERE Id = " + id + "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public List<User> getAllUsers() {       // получить всех юзеров из базы данных

        List<User> users = new ArrayList<>();
        try {

            Statement statement = Util.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                Byte age = resultSet.getByte("age");//
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setLastName(lastName);
                user.setAge(age);
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }



    public void cleanUsersTable() {
        try {
            Statement statement = Util.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}