package mainServer.controller;

import java.sql.*;
import java.util.ArrayList;

import mainServer.models.HistoryModel;
import mainServer.models.ChartDataModel;


//controller to send chartdata(s) which are retrived from mysql database
public class HistoryController {

    Connection con = null;
    public HistoryController(){
        String url = "jdbc:mysql://localhost:3306/file_system";
        String userName = "root";
        String password = "sudha10";

        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //to save the user search history
    public void saveHistory(String directoryPath, String keyword,String phone){
        String sql = "insert into history values (?,?,?)";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, directoryPath);
            pst.setString(2, keyword);
            pst.setString(3, phone);
            pst.executeUpdate();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }

    //to get chartdata(s) of most searched stuff and return as HistoryModel
    public HistoryModel getMostSearched(String phone){
        return new HistoryModel(getMostSearchedKeyword(phone),getMostSearchedDirectory(phone));
    }

    //to get most searched keyword of particular user (LIMIT 5)
    public ArrayList<ChartDataModel> getMostSearchedKeyword(String phone){
        ArrayList<ChartDataModel> arr = new ArrayList<ChartDataModel>();
        String sql = "SELECT keyword, count(keyword) FROM history WHERE phone="+phone+" GROUP BY keyword ORDER BY COUNT(keyword) DESC LIMIT 5";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                arr.add(new ChartDataModel(rs.getString(1),rs.getString(2)));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return arr;
    }

    //to get most searched directory of particular user (LIMIT 5)
    public ArrayList<ChartDataModel> getMostSearchedDirectory(String phone){
        ArrayList<ChartDataModel> arr = new ArrayList<ChartDataModel>();
        String sql = "SELECT directorypath, count(directorypath) FROM history WHERE phone="+phone+" GROUP BY directorypath ORDER BY COUNT(directorypath) DESC LIMIT 5";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                arr.add(new ChartDataModel(rs.getString(1),rs.getString(2)));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return arr;
    }
    
}
