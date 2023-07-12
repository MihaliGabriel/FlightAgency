package model;

public class User {
    private Long id;
    private String username;
    private String password;
    private Long ref_role;

    public User() {

    }
    public User(Long id, String username, String password, Long ref_role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ref_role = ref_role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getRef_role() {
        return ref_role;
    }

    public void setRef_role(Long ref_role) {
        this.ref_role = ref_role;
    }
}
