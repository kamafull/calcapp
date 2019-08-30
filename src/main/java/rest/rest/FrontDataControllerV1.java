package rest.rest;

import org.springframework.web.bind.annotation.*;
import tech.utils.front.formDataAsmbl2;
import tech.utils.front.formDataAsmbl3;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping(value = "/front/")
public class FrontDataControllerV1 {

    formDataAsmbl3 formData3 = new formDataAsmbl3();
    formDataAsmbl2 formData2 = new formDataAsmbl2();

    //метод возвращает данные для заполнения формы на фронте в виду json в зависимости от передаваемого тайпа оборудования для квартирного
    @RequestMapping(value = "asmbl3", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String formDataAsmbl3 (@RequestParam(name = "eq_type") int eq_type) throws IOException, SQLException {
        return formData3.list(eq_type);
    }

    //метод возвращает данные для заполнения формы на фронте в виду json в зависимости от передаваемого тайпа оборудования для ВРУ
    @RequestMapping(value = "asmbl2", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String formDataAsmbl2 (@RequestParam(name = "eq_type") int eq_type) throws IOException, SQLException {
        return formData2.list(eq_type);
    }

}
