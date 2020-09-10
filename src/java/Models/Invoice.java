package Models;

public class Invoice {

    private int invoice_id;
    private int customer_id;
    private double bonus;
    private String price;
    private String date_time;

    public Invoice() {
    }

    public Invoice(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Invoice(int invoice_id, int customer_id, double bonus, String price, String date_time) {
        this.invoice_id = invoice_id;
        this.customer_id = customer_id;
        this.bonus = bonus;
        this.price = price;
        this.date_time = date_time;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
