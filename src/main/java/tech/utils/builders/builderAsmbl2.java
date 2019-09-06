package tech.utils.builders;

import org.json.JSONArray;
import org.json.JSONObject;
import tech.equipment.asmbls.vruAsmbl2;
import tech.equipment.details.listEq;


public class builderAsmbl2 {

    private int id;
    private int type;
    private int id_user;
    private String name;
    private String json_save;
    private listEq listEq_1;
    private listEq listEq_2;
    private listEq listEq_3;
    private vruAsmbl2 vrusw;

    public vruAsmbl2 resultAsmbl(String data) throws Exception {

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
        listEq_1 = new listEq(jj);

        json = jsongen.getJSONObject("outsw");
        jj = json.getJSONArray("list_eq");
        listEq_2 = new listEq(jj);

        json = jsongen.getJSONObject("ecs");
        jj = json.getJSONArray("list_eq");
        listEq_3 = new listEq(jj);

        vrusw = new vruAsmbl2(type, name, listEq_1, listEq_2, listEq_3);

        if (id == -1) vrusw.newidorder();
        else vrusw.setIdorder(id);

        return vrusw;
    }
}
