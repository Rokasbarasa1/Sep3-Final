package shared;

import java.time.LocalDate;

public class User {
    private int id;
    private int managerID;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private String status;
    private LocalDate employmentDate;
    private String accessLevel;

    public User(int id, int managerID, String username, String password, String fname, String lname, String email, String status, LocalDate employmentDate, String accessLevel) {
        this.id = id;
        this.managerID = managerID;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.status = status;
        this.employmentDate = employmentDate;
        this.accessLevel = accessLevel;
    }

    public User(int managerID, String username, String password, String fname, String lname, String email, String status, String accessLevel) {
        this.managerID = managerID;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.status = status;
        this.accessLevel = accessLevel;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, int managerID, String fname) {
        this.id = id;
        this.managerID = managerID;
        this.fname = fname;
    }

    public int getManagerID() {
        return managerID;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getEmail() {
        return email;
    }
    public String getStatus() {
        return status;
    }
    public String getAccessLevel() {
        return accessLevel;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
