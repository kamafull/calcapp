package old;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tech.equipment.asmbls.typicalSb;
import tech.equipment.details.circuitbreaker;
import tech.equipment.details.enclosure;
import tech.maths.calcswitchboard;
import old.createspecs.specSwitchboardv1;
import java.sql.SQLException;
import java.util.ArrayList;

public class reader_switchboardv1 {

    private int type;
    private int id_user;
    private String name;
    private String json_save;
    private int amount_incb;
    private int insw_switch;
    private int insw_in;
    private int pmeter_need;
    private int pmeter_net;
    private int insw_am;
    private circuitbreaker incb;
    private enclosure ecs;
    private int ecs_incab;
    private int ecs_outcab;
    private int ecs_busbar;


    public String result (String data) throws JSONException, SQLException {
        ArrayList<circuitbreaker> list_outcb = new ArrayList<>();
        JSONObject jsongen11 = new JSONObject(data);
        int id = jsongen11.getInt("id");
        id_user = jsongen11.getInt("id_user");
        JSONObject jsongen = jsongen11.getJSONObject("save_json");
        type = jsongen.getInt("type");
        name = jsongen.getString("name");
        json_save = jsongen.toString();
        JSONObject json = jsongen.getJSONObject("insw");
        amount_incb = json.getInt("amount_incb");
        JSONObject json1 = (JSONObject) json.get("incb");
        incb = new circuitbreaker(json1.getInt("incb_current"), json1.getInt("incb_voltage"), json1.getInt("incb_mnf"), json1.getInt("incb_series"));
        pmeter_need = json.getInt("pmeter_need");
        pmeter_net = json.getInt("pmeter_net");
        insw_switch = json.getInt("insw_switch");
        insw_in = json.getInt("insw_in");
        insw_am = json.getInt("insw_am");
        JSONArray array = jsongen.getJSONArray("list_outcb");
        JSONObject o = new JSONObject();
        for (int i = 0; i < array.length(); i++) {
            o = array.getJSONObject(i);
            list_outcb.add(new circuitbreaker(o.getInt("outcb_current"), o.getInt("outcb_voltage"), o.getInt("outcb_mnf"), o.getInt("outcb_series")));
        }
        json = jsongen.getJSONObject("comecs");
        ecs = new enclosure(json.getInt("ecs_mnf"), json.getString("ecs_size"), json.getInt("ecs_ip"), json.getInt("ecs_need_plate"), json.getInt("ecs_need_base"));
        ecs_incab = json.getInt("ecs_incab");
        ecs_outcab = json.getInt("ecs_outcab");
        ecs_busbar = json.getInt("ecs_busbar");

        typicalSb swv1 = new typicalSb(id_user, type, name, json_save, amount_incb, insw_switch, insw_in, pmeter_need, pmeter_net, insw_am, incb, list_outcb, ecs, ecs_incab, ecs_outcab, ecs_busbar);

        if (id == -1) swv1.newidorder();
        else swv1.setIdorder(id);
        swv1.saveCabineToBD();


        JSONObject jsonoutsw = new JSONObject();
        jsonoutsw.put("id", swv1.getIdorder());
        jsonoutsw.put("price", new calcswitchboard().price(swv1));
        //добавление алармов
        JSONArray alarms = new JSONArray();
        for (String s : swv1.createalalarms()) alarms.put(s);
        jsonoutsw.put("alarms", alarms);
        specSwitchboardv1 specSwitchboardv1 = new specSwitchboardv1();
        specSwitchboardv1.createspec(swv1);

        return jsonoutsw.toString();
    }


}
