package tech.utils.readers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tech.docs.offers.offer;
import tech.docs.specifications.specAsmbl3;
import tech.equipment.asmbls.apartAsmbl3;
import tech.equipment.details.circuitbreaker;
import tech.maths.asmbl3.calcAsmbl;
//import old.createspecs.specApartamentsw;

import java.sql.SQLException;
import java.util.ArrayList;

public class reader_apartamentsw {


    private int type;
    private int id_user;
    private String name;
    private String json_save;
    //private int ecs_apart;
    private listEq listEq_1;
    private listEq listEq_2;
    private calcAsmbl calcAsmbl;
    private int price;


    public String result(String data) throws Exception {
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
        //ecs_apart = json.getInt("ecs_apart");
        json = jsongen.getJSONObject("outsw");
        jj = json.getJSONArray("list_eq");
        listEq_2 = new listEq(jj,3);


        apartAsmbl3 apsw = new apartAsmbl3( type, id_user,  name, json_save, listEq_1, listEq_2 );

        if (id == -1) apsw.newidorder();
        else apsw.setIdorder(id);
        price = calcAsmbl.price(apsw);
        apsw.saveCabineToBD(price);

        JSONObject jsonoutsw = new JSONObject();
        jsonoutsw.put("id", apsw.getIdorder());
        jsonoutsw.put("price", price);
        //добавление алармов
        JSONArray alarms = new JSONArray();
        for (String s : apsw.createalalarms()) alarms.put(s);
        jsonoutsw.put("alarms", alarms);
        specAsmbl3 specAsmbl3 = new specAsmbl3();
        specAsmbl3.createspec(apsw);
        //specApartamentsw specApsw = new specApartamentsw();
        //specApsw.createspec(apsw);


        return jsonoutsw.toString();


    }


}
