package tech.utils.readers;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.equipment.details.circuitbreaker;
import tech.equipment.details.powermeter;
import tech.equipment.details.rcbo;
import tech.equipment.details.rcd;
import java.util.ArrayList;


@Data
public class listEq {

    ArrayList<circuitbreaker> listCb = new ArrayList<>();
    ArrayList<rcd> listRcd = new ArrayList<>();
    ArrayList<rcbo> listRcbo = new ArrayList<>();
    ArrayList<powermeter> listPmeter = new ArrayList<>();
    int ecs_apart;
    JSONObject a;

    public listEq(JSONArray list_eq, int type_asmbl) {

        //при type_asmbl = 3 (Квартирный шкаф) приняты следующие параметры : 1?3 полюса для cb (230,400 В), 2?4 полюса дял узо и диф. Ток уточеки 4.5 кА и хар-ка С для всех автоматов
        if (type_asmbl == 3) {
            for (int i = 0; i < list_eq.length(); i++) {
                int poles = 0;


                a = (JSONObject) list_eq.get(i);


                if (a.getInt("eq_type") == 1) {
                    if (a.getInt("voltage") == 230) poles = 1;
                    else if (a.getInt("voltage") == 400) poles = 3;
                    listCb.add(new circuitbreaker(a.getInt("current"), a.getInt("voltage"), a.getInt("mnf"), poles, a.getString("series"), "4.5", "C", a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 2) {
                    if (a.getInt("voltage") == 230) poles = 2;
                    else if (a.getInt("voltage") == 400) poles = 4;
                    listRcd.add(new rcd(a.getInt("current"), 30, a.getInt("voltage"), a.getInt("mnf"), a.getString("series"), poles, "4.5", "C", a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 3) {
                    if (a.getInt("voltage") == 230) poles = 2;
                    else if (a.getInt("voltage") == 400) poles = 4;
                    listRcbo.add(new rcbo(a.getInt("current"), 30, a.getInt("voltage"), a.getInt("mnf"), a.getString("series"), poles, "4.5", "C", a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 4) {
                    listPmeter.add(new powermeter(a.getInt("mnf"), a.getInt("voltage"), 60, a.getInt("tariff"), a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 5) {
                    ecs_apart = a.getInt("ecs_apart");
                     }

            }


        }

    }


}
