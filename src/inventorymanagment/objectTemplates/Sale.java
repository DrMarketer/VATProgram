/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.objectTemplates;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


/**
 *
 * @author Sargis
 */
public class Sale {
    private Date date;
    private String code;
    private int quantity;
    private double VAT;

    public Sale(String sDate, String code, int quantity, double VAT) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy", Locale.ENGLISH);
        this.date = new java.sql.Date(format.parse(sDate).getTime());
        this.code = code;
        this.quantity = quantity;
        this.VAT = VAT;
    }

    public Date getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getVAT() {
        return VAT;
    }
    
    
    
    
    
    
}
