package Models;

public class Tour_booking {

    private int tour_booking_id;
    private int customer_id;
    private int no_of_members;
    private String date;
    private double total_price;
    private String date_time;

    public Tour_booking() {
    }

    public Tour_booking(int tour_booking_id) {
        this.tour_booking_id = tour_booking_id;
    }

    public Tour_booking(int tour_booking_id, int customer_id, int no_of_members, String date, double total_price, String date_time) {
        this.tour_booking_id = tour_booking_id;
        this.customer_id = customer_id;
        this.no_of_members = no_of_members;
        this.date = date;
        this.total_price = total_price;
        this.date_time = date_time;
    }

    public int getTour_booking_id() {
        return tour_booking_id;
    }

    public void setTour_booking_id(int tour_booking_id) {
        this.tour_booking_id = tour_booking_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getNo_of_members() {
        return no_of_members;
    }

    public void setNo_of_members(int no_of_members) {
        this.no_of_members = no_of_members;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
