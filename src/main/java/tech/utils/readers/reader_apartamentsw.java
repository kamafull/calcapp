package tech.utils.readers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tech.equipment.asmbls.apartAsmbl3;
import tech.equipment.details.circuitbreaker;
import tech.maths.calcswitchboard;
//import old.createspecs.specApartamentsw;

import java.sql.SQLException;
import java.util.ArrayList;

public class reader_apartamentsw {


    private int type;
    private int id_user;
    private String name;
    private String json_save;
    private int ecs_apart;
    private listEq listEq_1;
    private listEq listEq_2;


    public String result(String data) throws JSONException, SQLException {
        ArrayList<circuitbreaker> list_outcb = new ArrayList<>() ;
        JSONObject jsongen11 = new JSONObject(data);
        int id = jsongen11.getInt("id");
        id_user = jsongen11.getInt("id_user");
        JSONObject jsongen = jsongen11.getJSONObject("save_json");
        type = jsongen.getInt("type");
        name = jsongen.getString("name");

        json_save = jsongen.toString();
        JSONObject json = jsongen.getJSONObject("insw");
        JSONArray jj;
        jj = json.getJSONArray("list_eq");
        System.out.println(jj.toString());
        listEq_1 = new listEq(jj,3);
        ecs_apart = json.getInt("ecs_apart");
        json = jsongen.getJSONObject("outsw");
        jj = json.getJSONArray("list_eq");
        listEq_2 = new listEq(jj,3);


        apartAsmbl3 apsw = new apartAsmbl3( type, id_user,  name, json_save, ecs_apart, listEq_1, listEq_2 );

        if (id == -1) apsw.newidorder();
        else apsw.setIdorder(id);
        apsw.saveCabineToBD();

        JSONObject jsonoutsw = new JSONObject();
        jsonoutsw.put("id", apsw.getIdorder());
        jsonoutsw.put("price", new calcswitchboard().price(apsw));
        //добавление алармов
        JSONArray alarms = new JSONArray();
        for (String s : apsw.createalalarms()) alarms.put(s);
        jsonoutsw.put("alarms", alarms);
        //specApartamentsw specApsw = new specApartamentsw();
        //specApsw.createspec(apsw);


        return jsonoutsw.toString();


    }


}
