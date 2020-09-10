package Models;

public class Invoice_details {

    private int invoice_details_id;
    private int invoice_id;
    private int stock_id;
    private double qty;
    private double total;
    private String date_time;

    public Invoice_details() {
    }

    public Invoice_details(int invoice_details_id) {
        this.invoice_details_id = invoice_details_id;
    }

    public Invoice_details(int invoice_details_id, int invoice_id, int stock_id, double qty, double total, String date_time) {
        this.invoice_details_id = invoice_details_id;
        this.invoice_id = invoice_id;
        this.stock_id = stock_id;
        this.qty = qty;
        this.total = total;
        this.date_time = date_time;
    }

    public int getInvoice_details_id() {
        return invoice_details_id;
    }

    public void setInvoice_details_id(int invoice_details_id) {
        this.invoice_details_id = invoice_details_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
