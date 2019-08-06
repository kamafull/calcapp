package rest.rest;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tech.utils.other.actionAsmbl;
import tech.utils.other.getAsmbl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping(value = "")
public class ActionsUsersControllerV1 {

    private tech.utils.other.getAsmbl getAsmbl = new getAsmbl();
    private actionAsmbl updateAsmbl = new actionAsmbl();

    @RequestMapping(value = "users/getasmbl", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getassamblies (@RequestParam(name = "id") String id, HttpServletResponse response) throws IOException, SQLException {
        ArrayList<JSONObject> entities = getAsmbl.getArray(Integer.parseInt(id));
        return entities.toString();
    }


    @RequestMapping(value = "users/updasmbl", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String updateAsmbl(@RequestBody String data) throws SQLException {
        System.out.println(data);
        updateAsmbl.update(data);;
        return "updated";
    }

    @RequestMapping(value = "users/saveasmbl", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public int saveAsmbl(@RequestBody String data) throws SQLException {
        System.out.println(data);
        int id = updateAsmbl.save(data);
        return id;
    }

    @RequestMapping(value = "users/delasmbl", method = RequestMethod.POST/*, consumes = MediaType.TEXT_PLAIN_VALUE*/)
    public String deleteAsmbl(@RequestParam (name = "id") String id) throws SQLException {
        System.out.println(id);
        updateAsmbl.delete(Integer.parseInt(id));
        return "deleted";
    }
}
