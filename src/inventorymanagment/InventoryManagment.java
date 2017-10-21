/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment;

import inventorymanagment.objectTemplates.ConnectionFactory;
import inventorymanagment.objectTemplates.Goods;
import inventorymanagment.objectTemplates.GoodsInput;
import inventorymanagment.objectTemplates.ReadFromFile;
import inventorymanagment.objectTemplates.Sale;
import java.text.ParseException;



/**
 *
 * @author Sargis
 */
public class InventoryManagment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        //Goods good = new Goods("B6");
        //GoodsInput gi = new GoodsInput(good,3,5,2.5);
        //ConnectionFactory.inputGoods(gi);
        //Sale sale = new Sale("20/10/17", "A3", 3, 2.2);
        //ConnectionFactory.inputSales(sale);
        //ReadFromFile.readTxtFileToInDb();
        ReadFromFile.readTxtFileToSaleDb();
    
        
    }
    
}
