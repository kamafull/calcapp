package tech.equipment.details;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.equipment.details.parts.*;

import java.util.ArrayList;


@Data
public class listEq {

    ArrayList<circuitbreaker> listCb = new ArrayList<>();
    ArrayList<rcd> listRcd = new ArrayList<>();
    ArrayList<rcbo> listRcbo = new ArrayList<>();
    ArrayList<powermeter> listPmeter = new ArrayList<>();
    ArrayList<body> listBody = new ArrayList<>();
    ArrayList<switches> listSwitches = new ArrayList<>();
    ArrayList<ammeter> listAmmeter = new ArrayList<>();
    ArrayList<voltmeter> listVoltmeter = new ArrayList<>();
    ArrayList<fuse> listFuse = new ArrayList<>();
    ArrayList<are> listAre = new ArrayList<>();
    int ecs_apart;
    int switch_type;
    JSONObject a;
    String series = "";
    public listEq(JSONArray list_eq) {

        //при type_asmbl = 3 (Квартирный шкаф) приняты следующие параметры : 1?3 полюса для cb (230,400 В), 2?4 полюса дял узо и диф. Ток уточеки 4.5 кА и хар-ка С для всех автоматов
            for (int i = 0; i < list_eq.length(); i++) {
                a = (JSONObject) list_eq.get(i);

                if (a.getInt("eq_type") == 1) {
                    listCb.add(new circuitbreaker(a.getInt("current"), a.getInt("poles"), a.getString("series"), a.getString("bct"), a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 2) {
                    listRcd.add(new rcd(a.getInt("current"), 30, a.getInt("voltage"), a.getInt("mnf"), a.getString("series"), a.getInt("poles"), "4.5", "C", a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 3) {
                    listRcbo.add(new rcbo(a.getInt("current"), 30, a.getInt("voltage"), a.getInt("mnf"), a.getString("series"), a.getInt("poles"), "4.5", "C", a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 4) {
                    listPmeter.add(new powermeter(a.getInt("mnf"), a.getInt("voltage"), 60, a.getInt("tariff"), a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 5) {
                    ecs_apart = a.getInt("ecs_apart");
                     }

                if (a.getInt("eq_type") == 6){
                    listSwitches.add(new switches(a.getInt("current"), a.getInt("poles"), a.getInt("reverse"), a.getString("series"), a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 7){
                    listAmmeter.add(new ammeter(a.getInt("amount"), a.getInt("type")));
                }

                if (a.getInt("eq_type") == 8){
                    listVoltmeter.add(new voltmeter(a.getInt("amount"), a.getInt("type")));
                }

                if (a.getInt("eq_type") == 9){
                    listFuse.add(new fuse(a.getInt("amount"), a.getString("series"), a.getInt("current")));
                }

                if (a.getInt("eq_type") == 10) {
                    listBody.add(new body(a.getInt("mnf"), a.getString("series"), a.getString("size"), a.getInt("ip"), 0, a.getInt("amount")));
                }

                if (a.getInt("eq_type") == 11) {
                    switch_type = a.getInt("switch_type");
                }

                if (a.getInt("eq_type") == 12) {
                    listAre.add(new are(a.getInt("amount"), a.getInt("current")));
                }

            }

        }

    }



