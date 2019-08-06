package rest.rest;

import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tech.utils.readers.reader_apartamentsw;
import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping(value = "")
public class MathEqControllerV1 {

    private reader_apartamentsw apsw = new reader_apartamentsw();
    private String  result = "";

    @RequestMapping(value = "math/apartsw", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String createapsw (@RequestBody String data) throws Exception {
        System.out.println(data);
        try {
            result = apsw.result(data);
        } catch (SQLException e) {e.printStackTrace();}
        System.out.println(result);
        return result;
    }
}






