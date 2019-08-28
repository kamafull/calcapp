package rest.rest;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tech.equipment.asmbls.apartAsmbl3;
import tech.maths.asmbl3.calcAsmbl3;
import tech.utils.builders.builderAsmbl3;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping(value = "")
public class MathEqControllerV1 {

    private calcAsmbl3 calcAsmbl3 = new calcAsmbl3();
    apartAsmbl3 asmbl3;
    private tech.utils.builders.builderAsmbl3 builderAsmbl3 = new builderAsmbl3();
    JSONObject result = new JSONObject();
    int price;

    @RequestMapping(value = "math/apartsw", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String createapsw (@RequestBody String data) throws Exception {
        System.out.println(data);
        asmbl3 = builderAsmbl3.resultAsmbl(data);
        price = calcAsmbl3.price(asmbl3);
        System.out.println(price);
        System.out.println(asmbl3.getIdorder());
        result.put("id", asmbl3.getIdorder());
        result.put("price", price);
        result.put("alarms", asmbl3.getAlarms());

        return result.toString();
    }
}






