/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment.objectTemplates;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sargis
 */
public class ConnectionFactory {
    
    Connection conn = null;
    public static Connection ConnectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:kahuyq.db");
        
        return con;
    } catch (HeadlessException | ClassNotFoundException | SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
    }
        return null;
}
    
    /*
    public static void insertGoods(Goods g){
        String sqlSelect = "Select * from good where good_code = '" + g.getCode() + "'" ;
        String sqlInsert = "INSERT INTO good (good_code)"
                + "VALUES ('" + g.getCode() +"')";
        Connection conn = ConnectionFactory.ConnectDB();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            
            
            while(!rs.next()){
                statement.executeUpdate(sqlInsert);
                break;
            }
        
        }
        catch(SQLException e){
        }
    }
*/
    
    public static void sqlStatement(String sql){
        System.out.print(sql);
        Connection conn = ConnectionFactory.ConnectDB();
        try{
            conn.setAutoCommit(false);
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.executeUpdate();
                conn.commit();
            }
            conn.close();
        }
        catch(SQLException e){
        }
    }
    
    public static void inputGoods(GoodsInput goodsinput){
        String goodCode = goodsinput.getInGood().getCode();
        int goodBatch = goodsinput.getInGroup();
        int goodQuantity = goodsinput.getInQuantity();
        double goodVATPaid = goodsinput.getInVatPaid();
        String sqlInsert = "INSERT INTO good_in (good_code, in_group, in_quantity, in_VATPaid)"
                + " VALUES ('" + goodCode + "', " + "'" + goodBatch + "', " + "'" + goodQuantity 
                + "', " + "'" +goodVATPaid + "');";
        sqlStatement(sqlInsert);
    }
    
    public static void inputSales(Sale sale){
        Date date = sale.getDate();
        String code = sale.getCode();
        int quantity = sale.getQuantity();
        double vAT = sale.getVAT();
        
        String sqlSale = "INSERT INTO good_sale (sale_date, sale_good_code, sale_quantity, VATFromSale)"
                + " VALUES ('" + date + "', " +"'" + code + "', " + "'" + 1 + "', " + "'" + vAT + "');";
        for(int i = 0; i < quantity; i++){
            sqlStatement(sqlSale);
        }
    }
    
}
