package sample;

import java.sql.*;

public class DataBase implements Dao{
    Connection con;
    Statement state;

    DataBase(){
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:students.s3db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        init();
    }

    public void init(){
        try {
            state = con.createStatement();
            state.execute("CREATE TABLE if not exists 'articles' ('id' INTEGER PRIMARY KEY, 'prof' text);");
            state.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getData(String index) {
        try {
            state = con.createStatement();
            ResultSet resSet = state.executeQuery("SELECT prof FROM articles WHERE id = " + index + ";");
            String res;
            if (resSet.next()){
                res = resSet.getString(1);
            } else {
                res = "запись по этой проффесии не найдена";
            }
            resSet.close();
            return res;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return "error";
    }
}
