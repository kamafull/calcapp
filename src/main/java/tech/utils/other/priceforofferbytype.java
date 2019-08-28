package tech.utils.other;


import org.json.JSONObject;
import tech.equipment.asmbls.apartAsmbl3;
import tech.maths.asmbl3.calcAsmbl3;
import tech.utils.builders.builderAsmbl3;


public class priceforofferbytype {

    int price = 0;

    calcAsmbl3 calcAsmbl3 = new calcAsmbl3();
    builderAsmbl3 builderAsmlb3 = new builderAsmbl3();
    JSONObject jsongen;
    JSONObject jsonObject = new JSONObject();
    private apartAsmbl3 apsw;


    public int price (int type1, String data) throws Exception {

        if (type1 == 3){

            jsongen = new JSONObject(data);
            jsonObject.put("save_json", jsongen);
            jsonObject.put("id",-1);
            jsonObject.put("id_user", -1);
            apsw = builderAsmlb3.resultAsmbl(jsonObject.toString());
            price = calcAsmbl3.price(apsw);

        }
        return price;
    }

}
