package tech.utils.other;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

public class getAsmbl {

    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";



    public ArrayList<JSONObject> getArray(int id) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            ArrayList<JSONObject> array = new ArrayList<>();
            JSONObject a;
            String sql = "SELECT * FROM circuit_breakers.saves_cabinets WHERE id_user = " + id + ";";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                a = new JSONObject(rs.getString("save_json"));
                //System.out.println(a);
                a.put("id", rs.getInt("id"));
                array.add(a);


            }

            return array;
        }
    }











}
