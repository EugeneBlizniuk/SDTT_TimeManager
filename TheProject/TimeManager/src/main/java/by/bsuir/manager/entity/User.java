package by.bsuir.manager.entity;

import java.util.Objects;

public class User extends Entity{
    private String login;
    private String password;
    private int id;
    private String time;

    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.id = this.hashCode();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User)o;

        return this.login.equals(user.login) &&
                this.password.equals(user.password) &&
                this.id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
