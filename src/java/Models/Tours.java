package Models;

public class Tours {

    private int tours;
    private String category;
    private String name;
    private String start_location;
    private String end_location;
    private double price;
    private String special;
    private String description;
    private String status;
    private String date_time;

    public Tours() {
    }

    public Tours(int tours) {
        this.tours = tours;
    }

    public Tours(int tours, String category, String name, String start_location, String end_location, double price, String special, String description, String status, String date_time) {
        this.tours = tours;
        this.category = category;
        this.name = name;
        this.start_location = start_location;
        this.end_location = end_location;
        this.price = price;
        this.special = special;
        this.description = description;
        this.status = status;
        this.date_time = date_time;
    }

    public int getTours() {
        return tours;
    }

    public void setTours(int tours) {
        this.tours = tours;
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

    public String getStart_location() {
        return start_location;
    }

    public void setStart_location(String start_location) {
        this.start_location = start_location;
    }

    public String getEnd_location() {
        return end_location;
    }

    public void setEnd_location(String end_location) {
        this.end_location = end_location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
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
