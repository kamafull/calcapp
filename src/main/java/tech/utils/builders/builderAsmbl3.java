package tech.utils.builders;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.equipment.asmbls.apartAsmbl3;
import tech.equipment.details.circuitbreaker;
import tech.equipment.details.listEq;

import java.util.ArrayList;

@Data
public class builderAsmbl3 {

    private int id;
    private int type;
    private int id_user;
    private String name;
    private String json_save;
    private listEq listEq_1;
    private listEq listEq_2;
    private int price;
    private apartAsmbl3 apsw;
    private JSONArray alarms = new JSONArray();

    public apartAsmbl3 resultAsmbl(String data) throws Exception {

        ArrayList<circuitbreaker> list_outcb = new ArrayList<>() ;
        JSONObject jsongen11 = new JSONObject(data);
        id = jsongen11.getInt("id");
        id_user = jsongen11.getInt("id_user");
        JSONObject jsongen = jsongen11.getJSONObject("save_json");
        type = jsongen.getInt("type");
        name = jsongen.getString("name");
        json_save = jsongen.toString();
        JSONObject json = jsongen.getJSONObject("insw");
        JSONArray jj;
        jj = json.getJSONArray("list_eq");

        for (int i = 0; i < jj.length(); i++) {
            if (jj.getJSONObject(i).getInt("eq_type") == 1){
                if (jj.getJSONObject(i).getInt("mnf") == 3) jj.getJSONObject(i).put("series", "ВА47-29 (MVA20)");
                if (jj.getJSONObject(i).getInt("mnf") == 6) jj.getJSONObject(i).put("series", "BasicM (Квартирный)");
                if (jj.getJSONObject(i).getInt("voltage") == 230) jj.getJSONObject(i).put("poles",1);
                if (jj.getJSONObject(i).getInt("voltage") == 400) jj.getJSONObject(i).put("poles",3);
            }
            if (jj.getJSONObject(i).getInt("eq_type") == 2) {
                if (jj.getJSONObject(i).getInt("voltage") == 230) jj.getJSONObject(i).put("poles",1);
                if (jj.getJSONObject(i).getInt("voltage") == 400) jj.getJSONObject(i).put("poles",3);
            }
            if (jj.getJSONObject(i).getInt("eq_type") == 3) {
                if (jj.getJSONObject(i).getInt("voltage") == 230) jj.getJSONObject(i).put("poles",1);
                if (jj.getJSONObject(i).getInt("voltage") == 400) jj.getJSONObject(i).put("poles",3);
            }
            if (jj.getJSONObject(i).getInt("eq_type") == 4) {
                if (jj.getJSONObject(i).getInt("voltage") == 230) jj.getJSONObject(i).put("poles",1);
                if (jj.getJSONObject(i).getInt("voltage") == 400) jj.getJSONObject(i).put("poles",3);
            }
        }

        listEq_1 = new listEq(jj);
        json = jsongen.getJSONObject("outsw");
        jj = json.getJSONArray("list_eq");

        for (int i = 0; i < jj.length(); i++) {
            if (jj.getJSONObject(i).getInt("eq_type") == 1){
                if (jj.getJSONObject(i).getInt("mnf") == 3) jj.getJSONObject(i).put("series", "ВА47-29 (MVA20)");
                if (jj.getJSONObject(i).getInt("mnf") == 6) jj.getJSONObject(i).put("series", "BasicM (Квартирный)");
                if (jj.getJSONObject(i).getInt("voltage") == 230) jj.getJSONObject(i).put("poles",1);
                if (jj.getJSONObject(i).getInt("voltage") == 400) jj.getJSONObject(i).put("poles",3);
            }
            if (jj.getJSONObject(i).getInt("eq_type") == 2) {
                if (jj.getJSONObject(i).getInt("voltage") == 230) jj.getJSONObject(i).put("poles",1);
                if (jj.getJSONObject(i).getInt("voltage") == 400) jj.getJSONObject(i).put("poles",3);
            }
            if (jj.getJSONObject(i).getInt("eq_type") == 3) {
                if (jj.getJSONObject(i).getInt("voltage") == 230) jj.getJSONObject(i).put("poles",1);
                if (jj.getJSONObject(i).getInt("voltage") == 400) jj.getJSONObject(i).put("poles",3);
            }
            if (jj.getJSONObject(i).getInt("eq_type") == 4) {
                if (jj.getJSONObject(i).getInt("voltage") == 230) jj.getJSONObject(i).put("poles",1);
                if (jj.getJSONObject(i).getInt("voltage") == 400) jj.getJSONObject(i).put("poles",3);
            }
        }

        listEq_2 = new listEq(jj);
        apsw = new apartAsmbl3(type, name, listEq_1, listEq_2);

        if (id == -1) apsw.newidorder();
        else apsw.setIdorder(id);

        return apsw;

    }

}
