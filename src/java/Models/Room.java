package Models;

public class Room {

    private int room_id;
    private String category;
    private String name;
    private int qty;
    private double price;
    private String status;
    private String date_time;

    public Room() {
    }

    public Room(int room_id) {
        this.room_id = room_id;
    }

    public Room(int room_id, String category, String name, int qty, double price, String status, String date_time) {
        this.room_id = room_id;
        this.category = category;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.status = status;
        this.date_time = date_time;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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
