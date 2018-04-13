package tables;

import javax.persistence.*;

@Entity
@Table (name = "user")
public class User {

    @Id
    @Column (name = "id")
    private  int id;
    @Column (name = "name" )
    private  String name;
    @Column (name = "login")
    private  String login;
    @Column (name = "password")
    private  String password;

    public User(String login) {
        this.login = login;
    }

    public User( int id,  String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
