package pojo;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 08:20
 * @Description:User实体类
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int type;
    private int status;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, int type, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    public User(String username, String password, int type, int status) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    public User() {
    }
}
