/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.objectTemplates;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sargis
 */
public class ReadFromFile {
    public static void readTxtFileToInDb(){
        String inFileName = "in.txt";
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(inFileName))) {
                while(reader.ready()){
                    String line = reader.readLine();
                    String[] lineSplit = line.split("\t");
                    Goods good = new Goods(lineSplit[0]);
                    GoodsInput gi = new GoodsInput(good, Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]), Double.parseDouble(lineSplit[3]));
                    ConnectionFactory.inputGoods(gi);
                    
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFromFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void readTxtFileToSaleDb(){
        String saleFileName = "out.txt";
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(saleFileName))) {
                while(reader.ready()){
                    String line = reader.readLine();
                    String[] lineSplit = line.split("\t");
                    Sale sale = new Sale(lineSplit[0], lineSplit[1], Integer.parseInt(lineSplit[2]), Double.parseDouble(lineSplit[3]));
                    ConnectionFactory.inputSales(sale);
                    
                }
            } catch (ParseException ex) {
                Logger.getLogger(ReadFromFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFromFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    
}


