package Models;

public class Event {

    private int event_id;
    private String category;
    private String date;
    private String time;
    private int no_of_members;
    private double price;
    private String status;
    private String date_time;

    public Event() {
    }

    public Event(int event_id) {
        this.event_id = event_id;
    }

    public Event(int event_id, String category, String date, String time, int no_of_members, double price, String status, String date_time) {
        this.event_id = event_id;
        this.category = category;
        this.date = date;
        this.time = time;
        this.no_of_members = no_of_members;
        this.price = price;
        this.status = status;
        this.date_time = date_time;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNo_of_members() {
        return no_of_members;
    }

    public void setNo_of_members(int no_of_members) {
        this.no_of_members = no_of_members;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
