package tech.equipment.asmbls;

import lombok.Data;
import tech.equipment.details.parts.circuitbreaker;
import tech.equipment.details.listEq;
import tech.utils.other.mnfBack;
import tech.utils.other.pricingListEq;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

@Data
public class vruAsmbl2 {

    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";

    private int idorder;
    private int type;
    private int id_user;
    private String name;
    private String json_string;
    private listEq listEq_1;
    private listEq listEq_2;
    private listEq listEq_3;
    private ArrayList<String> alarms;

    public void newidorder(){
        this.idorder = new Random().nextInt(99999);
    }

    public vruAsmbl2(int type, String name, listEq listeq_1, listEq listEq_2, listEq listEq_3) {
        this.type = type;
        this.name = name;
        this.listEq_1 = listeq_1;
        this.listEq_2 = listEq_2;
        this.listEq_3 = listEq_3;

    }

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
