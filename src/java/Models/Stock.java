package Models;

public class Stock {

    private int stock_id;
    private String category;
    private String name;
    private double price;
    private double qty;
    private String status;
    private String date_time;

    public Stock() {
    }

    public Stock(int stock_id) {
        this.stock_id = stock_id;
    }

    public Stock(int stock_id, String category, String name, double price, double qty, String status, String date_time) {
        this.stock_id = stock_id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.status = status;
        this.date_time = date_time;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
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
