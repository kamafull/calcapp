package tech.equipment.asmbls;

import lombok.Data;
import tech.equipment.details.circuitbreaker;
import tech.utils.other.pricingListEq;
import tech.utils.other.mnfBack;
import tech.equipment.details.listEq;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

@Data
public class apartAsmbl3 {


    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";

    private int idorder;
    private int type;
    private int id_user;
    private String name;
    private String json_string;
    //private int ecs_apart;
    private listEq listEq_1;
    private listEq listEq_2;
    private ArrayList<String> alarms;

    public void newidorder(){
        this.idorder = new Random().nextInt(99999);
    }

    public apartAsmbl3(int type, String name, listEq listeq_1, listEq listEq_2) {
        this.type = type;
        this.name = name;
        this.listEq_1 = listeq_1;
        this.listEq_2 = listEq_2;

    }

    /*
    public void saveCabineToBD(int price){
        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            String sql;
            sql = "SELECT * from circuit_breakers.saves_cabinets where id = " + idorder + ";";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                sql = "update circuit_breakers.saves_cabinets SET save_json = '" + json_string  +  "', price = " + price + " WHERE id = " + idorder + ";";
                stat.execute(sql);
            }
            else {
                sql = "INSERT INTO circuit_breakers.saves_cabinets (id_user, id, name, type, save_json, price) VALUES (" + id_user + ", " + idorder + ", '" + name + "', " + type + ", '" + json_string + "'," + price+ ");";

                stat.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    */
    public ArrayList<String> createalalarms () throws SQLException {
        int k = 0;
        int k1 = 0;
        ArrayList<String> bufalarm = new ArrayList<>();
        //определяем ошибку на номинал автоматов
        for (circuitbreaker c : listEq_2.getListCb()) {
            k += c.getCurrent();
        }

        for (circuitbreaker c : listEq_1.getListCb()) {
            k1 += c.getCurrent();
        }

        if (k > k1){
            bufalarm.add("Внимание! Номиналы вводных линий меньше отходящих");
        }
        else bufalarm.add("Проверка по номиналам пройдена успешно");
        //блок закрыт
        pricingListEq p = new pricingListEq();
        mnfBack mb = new mnfBack();
        for (circuitbreaker incb : listEq_1.getListCb()) {
            if (p.price(incb) == 0)
                bufalarm.add("Внимание! Отходящий автомат автомат " + mb.mnfname(incb.getManufacturer()) + " в базе не найден и в расчет не включен");
        }
        for (circuitbreaker incb : listEq_2.getListCb()) {
            if (p.price(incb) == 0)
                bufalarm.add("Внимание! Отходящий автомат автомат " + mb.mnfname(incb.getManufacturer()) + " в базе не найден и в расчет не включен");
        }
        alarms = bufalarm;
        return alarms;

    }


}
