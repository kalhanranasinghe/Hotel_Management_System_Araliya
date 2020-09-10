package Models;

public class User {

    private int user_id;
    private String full_name;
    private String user_type;
    private String username;
    private String password;
    private String date_time;

    public User() {
    }

    public User(int user_id) {
        this.user_id = user_id;
    }

    public User(int user_id, String full_name, String user_type, String username, String password, String date_time) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.user_type = user_type;
        this.username = username;
        this.password = password;
        this.date_time = date_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
