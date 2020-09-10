package Models;

public class Housekeeping {

    private int housekeeping_id;
    private int employee_id;
    private String task;
    private String description;
    private String status;
    private String date_time;

    public Housekeeping() {
    }

    public Housekeeping(int housekeeping_id) {
        this.housekeeping_id = housekeeping_id;
    }

    public Housekeeping(int housekeeping_id, int employee_id, String task, String description, String status, String date_time) {
        this.housekeeping_id = housekeeping_id;
        this.employee_id = employee_id;
        this.task = task;
        this.description = description;
        this.status = status;
        this.date_time = date_time;
    }

    public int getHousekeeping_id() {
        return housekeeping_id;
    }

    public void setHousekeeping_id(int housekeeping_id) {
        this.housekeeping_id = housekeeping_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
