package Models;

public class Reservation {

    private int reservation_id;
    private int room_id;
    private String start_date;
    private String end_date;
    private int no_of_members;
    private double total;
    private String status;
    private String date_time;

    public Reservation() {
    }

    public Reservation(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Reservation(int reservation_id, int room_id, String start_date, String end_date, int no_of_members, double total, String status, String date_time) {
        this.reservation_id = reservation_id;
        this.room_id = room_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.no_of_members = no_of_members;
        this.total = total;
        this.status = status;
        this.date_time = date_time;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getNo_of_members() {
        return no_of_members;
    }

    public void setNo_of_members(int no_of_members) {
        this.no_of_members = no_of_members;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
