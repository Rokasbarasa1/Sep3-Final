package shared;

import java.time.LocalDate;

public class Shift {
    private int id;
    private int user_id;
    private int manager_id;
    private String description;
    private LocalDate date;

    public Shift(int id, int user_id, String description, int manager_id, LocalDate date) {
        this.id = id;
        this.user_id = user_id;
        this.description = description;
        this.manager_id = manager_id;
        this.date = date;
    }

    public Shift(int user_id, String description, int manager_id, LocalDate date) {
        this.user_id = user_id;
        this.description = description;
        this.manager_id = manager_id;
        this.date = date;
    }

    public Shift(int user_id, LocalDate date) {
        this.user_id = user_id;
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public int getManager_id() {
        return manager_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDate() {
        return date;
    }
}
