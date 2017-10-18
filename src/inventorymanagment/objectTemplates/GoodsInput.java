/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.objectTemplates;

import java.sql.*;

/**
 *
 * @author Sargis
 */
public class GoodsInput {
    private Goods inGood;
    private int inGroup;
    private int inQuantity;
    private double inVatPaid;

    public GoodsInput(Goods inGood, int inGroup, int inQuantity, double inVatPaid) {
        this.inGood = inGood;
        this.inGroup = inGroup;
        this.inQuantity = inQuantity;
        this.inVatPaid = inVatPaid;
    }

    public Goods getInGood() {
        return inGood;
    }

    public int getInGroup() {
        return inGroup;
    }

    public int getInQuantity() {
        return inQuantity;
    }

    public double getInVatPaid() {
        return inVatPaid;
    }
    
    
    
}
