package old;

import lombok.Data;
import tech.equipment.details.circuitbreaker;
import tech.equipment.details.enclosure;
import tech.equipment.details.powermeter;
import tech.maths.pricing;
import tech.utils.other.mnfBack;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

@Data
public class generalSb {

    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";

    private int idorder;
    private circuitbreaker incb;
    private powermeter pmeter;
    private int amount_incb;
    private int air_type;
    private int pmeter_need;
    private int pmeter_amount = 0;
    public ArrayList<circuitbreaker> list_outcb ;
    private enclosure ecs;
    private int ecs_amount;
    private int switch_need;
    private ArrayList<String> alarms;
    private String name;
    private String json_string;
    private int type;
    private int id_user;

    public void newidorder(){
        this.idorder = new Random().nextInt(99999);
    }

      public generalSb(int id_user, int type, String name, String json_string, int amount_incb, circuitbreaker incb, int ait_type, int pmeter_need, int pmeter_amount, powermeter pmeter, ArrayList<circuitbreaker> list_outcb, enclosure ecs, int ecs_amount, int switch_need) {
        this.id_user = id_user;
        this.type = type;
        this.amount_incb = amount_incb;
        this.incb = incb;
        this.air_type = ait_type;
        this.pmeter_need = pmeter_need;
        this.pmeter_amount = pmeter_amount;
        this.pmeter = pmeter;
        this.list_outcb = list_outcb;
        this.ecs = ecs;
        this.ecs_amount = ecs_amount;
        this.switch_need = switch_need;
        this.name = name;
        this.json_string = json_string;

    }

    public void saveCabineToBD(){



        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            String sql;
            sql = "SELECT * from circuit_breakers.saves_cabinets where id = " + idorder + ";";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                 sql = "update circuit_breakers.saves_cabinets SET save_json = '" + json_string  +  "' WHERE id = " + idorder + ";";
                stat.execute(sql);

            }
            else {
                sql = "INSERT INTO circuit_breakers.saves_cabinets (id_user, id, name, type, save_json) VALUES (" + id_user + ", " + idorder + ", '" + name + "', " + type + ", '" + json_string + "');";
                stat.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



        public ArrayList<String> createalalarms () throws SQLException {
            int k = 0;
            ArrayList<String> bufalarm = new ArrayList<>();
            //определяем ошибку на номинал автоматов
            for (circuitbreaker c : list_outcb) {
                k += c.getCurrent();
            }
            if (k > incb.getCurrent()) bufalarm.add("Внимание! Номиналы вводных линий меньше отходящих");
            else bufalarm.add("Проверка по номиналам пройдена успешно");
            //блок закрыт
            pricing p = new pricing();
            mnfBack mb = new mnfBack();
            if (p.price(ecs) == 0) bufalarm.add("Внимание! Корпус в базе не найден и в расчет не включен");
            if (p.price(incb) == 0) bufalarm.add("Внимание! Вводной автомат в базе не найден и в расчет не включен");
            for (circuitbreaker incb : list_outcb) {
                if (p.price(incb) == 0)
                    bufalarm.add("Внимание! Отходящий автомат автомат " + mb.mnfname(incb.getManufacturer()) + " в базе не найден и в расчет не включен");
            }
            alarms = bufalarm;
            return alarms;

        }

    }

