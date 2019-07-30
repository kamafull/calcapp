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
    JSONObject a;

    public listEq(JSONArray list_eq){

    for (int i = 0; i < list_eq.length(); i++){

        a = (JSONObject) list_eq.get(i);

        if (a.getInt("eq_type") == 1){
            listCb.add(new circuitbreaker(a.getInt("current"), a.getInt("voltage"), a.getInt("mnf"), a.getInt("poles"), a.getString("series") ,4, "C", a.getInt("amount")));
        }

        if (a.getInt("eq_type") == 2){
            listRcd.add(new rcd(a.getInt("current"), 30, a.getInt("voltage"), a.getInt("mnf"), a.getString("series"), a.getInt("poles"), 4, "C", a.getInt("amount")));
        }

        if (a.getInt("eq_type") == 3){
            listRcbo.add(new rcbo(a.getInt("current"), 30, a.getInt("voltage"), a.getInt("mnf"), a.getString("series"), a.getInt("poles"), 4, "C", a.getInt("amount")));
        }

        if (a.getInt("eq_type") == 4){
            listPmeter.add(new powermeter(a.getInt("mnf"), a.getInt("voltage"), a.getInt("current"),a.getInt("tariff") ,a.getInt("amount")));
        }

    }


    }




}
