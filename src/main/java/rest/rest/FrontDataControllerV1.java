package rest.rest;

import org.springframework.web.bind.annotation.*;
import tech.utils.front.formDataAsmbl3;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping(value = "/front/")
public class FrontDataControllerV1 {

    formDataAsmbl3 formData = new formDataAsmbl3();

    //метод возвращает данные для заполнения формы на фронте в виду json в зависимости от передаваемого тайпа оборудования
    @RequestMapping(value = "asmbl3", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String formData (@RequestParam(name = "eq_type") int eq_type) throws IOException, SQLException {
        return formData.list(eq_type);
    }


}
