package table;

import javax.persistence.*;

@Entity
@Table (name = "user")
public class User {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int  id;
    @Column (name = "name")
    private  String name;
    @Column (name = "login", unique =  true)
    private  String login;
    @Column (name = "password")
    private  String password;


    public User() {

    }
    public User(String login) {
        this.login = login;
    }

    public User(  String name, String login, String password) {

        this.name = name;
        this.login = login;
        this.password = password;
    }

    public void setId(int  id) {
        this.id = id;
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
        return "User {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
