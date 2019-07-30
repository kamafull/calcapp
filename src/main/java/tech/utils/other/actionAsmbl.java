package tech.utils.other;


import org.json.JSONObject;

import java.sql.*;
import java.util.Random;

public class actionAsmbl {

    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";

    public void update(String data) throws SQLException {
        JSONObject json = new JSONObject(data);
        int id = json.getInt("id");
        int id_user = json.getInt("id_user");
        JSONObject save = json.getJSONObject("save_json");
        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            String sql = "update circuit_breakers.saves_cabinets SET save_json = '" + save.toString()  +  "' WHERE id_user = " + id_user + " and id = " + id + ";";
            stat.execute(sql);
        }
    }
    public int save(String data) throws SQLException{

        JSONObject json = new JSONObject(data);
        int id = new Random().nextInt(99999);
        int id_user = json.getInt("id_user");
        JSONObject save = json.getJSONObject("save_json");
        String name = save.getString("name");
        int type = save.getInt("type");

        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            String sql = "insert into circuit_breakers.saves_cabinets (id_user, id, name, type, save_json) VALUES (" + id_user + ", " + id + ", '" + name + "', "  + type + ", '" + save.toString() + "');";
            stat.execute(sql);
        }
        return id;
    }

    public void delete(int id) throws SQLException{
        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            String sql = "delete from circuit_breakers.saves_cabinets where id = " + id + ";";
            stat.execute(sql);
        }
    }
}
