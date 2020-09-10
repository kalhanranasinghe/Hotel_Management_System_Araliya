package Controllers;

import Models.Stock;
import DBConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StockController {

    Connector con = Connector.getInstance();

    private StockController() {
    }

    private static final StockController obj = new StockController();

    public static StockController getInstance() {
        return obj;
    }

    public void Save(Stock data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO stock(category,name,price,qty,status,date_time) values ('" + data.getCategory() + "','" + data.getName() + "','" + data.getPrice() + "','" + data.getQty() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Stock data) throws Exception {
        con.getConnection();
        con.aud("UPDATE stock SET category  = '" + data.getCategory() + "',name  = '" + data.getName() + "',price  = '" + data.getPrice() + "',qty  = '" + data.getQty() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE stock_id = '" + data.getStock_id() + "'");
    }

    public void Delete(Stock data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM stock WHERE stock_id = '" + data.getStock_id() + "'");
    }

    public List<Stock> SearchAll() throws Exception {
        List<Stock> objList = new ArrayList<Stock>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM stock");
        while (rset.next()) {
            Stock obj = new Stock();
            obj.setStock_id(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setName(rset.getString(3));
            obj.setPrice(rset.getDouble(4));
            obj.setQty(rset.getDouble(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

    public List<Stock> Search(Stock data) throws Exception {
        List<Stock> objList = new ArrayList<Stock>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM stock WHERE stock_id = '" + data.getStock_id() + "'");
        while (rset.next()) {
            Stock obj = new Stock();
            obj.setStock_id(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setName(rset.getString(3));
            obj.setPrice(rset.getDouble(4));
            obj.setQty(rset.getDouble(5));
            obj.setStatus(rset.getString(6));
            obj.setDate_time(rset.getString(7));
            objList.add(obj);
        }

        return objList;
    }

}
