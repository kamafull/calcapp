package old;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tech.equipment.details.circuitbreaker;
import tech.equipment.details.enclosure;
import tech.equipment.details.powermeter;
import tech.maths.calcswitchboard;
import old.createspecs.specSwitchboard;


import java.sql.SQLException;
import java.util.ArrayList;

public class reader_switchboard {

    private int id_user;
    private int type;
    private String name;
    private String json_save;
    private circuitbreaker incb;
    private powermeter pmeter;
    private int amount_incb;
    private int air_type;
    private int pmeter_need;
    private int pmeter_amount = 0;
    private enclosure ecs;
    private int ecs_amount;
    private int switch_need;


    //ниже кладешь readers получаешь класс generalSb на выходе
    public String result (String data) throws JSONException, SQLException {
        ArrayList<circuitbreaker> list_outcb = new ArrayList<>();
        JSONObject jsongen = new JSONObject(data);
        int id = jsongen.getInt("id");
        id_user = jsongen.getInt("id_user");
        type = jsongen.getInt("type");
        name = jsongen.getString("name");
        json_save = jsongen.toString();
        JSONObject json = jsongen.getJSONObject("insw");
        amount_incb = json.getInt("amount_incb");
        JSONObject json1 = (JSONObject) json.get("incb");
        incb = new circuitbreaker(json1.getInt("incb_current"), json1.getInt("incb_voltage"), json1.getInt("incb_mnf"), json1.getInt("incb_series"));
        air_type = json.getInt("air_type");
        pmeter_need = json.getInt("pmeter_need");
        pmeter_amount = json.getInt("pmeter_amount");
        JSONObject json2 = (JSONObject) json.get("pmeter");
        pmeter = new powermeter(json2.getInt("pmeter_mnf"), json2.getInt("pmeter_net"), incb.getVoltage(), incb.getCurrent());
        JSONArray array = jsongen.getJSONArray("list_outcb");
        JSONObject o = new JSONObject();
        for (int i = 0; i < array.length(); i++) {
            o = array.getJSONObject(i);
            list_outcb.add(new circuitbreaker(o.getInt("outcb_current"), o.getInt("outcb_voltage"), o.getInt("outcb_mnf"), o.getInt("outcb_series")));
        }
        json = jsongen.getJSONObject("comecs");
        ecs = new enclosure(json.getInt("ecs_mnf"), json.getString("ecs_size"), json.getInt("ecs_ip"), json.getInt("ecs_need_plate"), json.getInt("ecs_need_base"));
        ecs_amount = json.getInt("ecs_amount");
        switch_need = json.getInt("switch_need");
        //tech.maths.pricing pricing = new pricing();

        generalSb sw = new generalSb(id_user, type, name, json_save, amount_incb, incb, air_type, pmeter_need, pmeter_amount, pmeter, list_outcb, (enclosure) ecs, ecs_amount, switch_need);

        if (id == -1) sw.newidorder();
        else sw.setIdorder(id);
        sw.saveCabineToBD();

        JSONObject jsonoutsw = new JSONObject();
        jsonoutsw.put("id", sw.getIdorder());
        jsonoutsw.put("price", new calcswitchboard().price(sw));
        //добавление алармов
        JSONArray alarms = new JSONArray();
        for (String s : sw.createalalarms()) alarms.put(s);
        jsonoutsw.put("alarms", alarms);
        specSwitchboard specSwitchboard = new specSwitchboard();
        specSwitchboard.createspec(sw);


        return jsonoutsw.toString();


    }
}
