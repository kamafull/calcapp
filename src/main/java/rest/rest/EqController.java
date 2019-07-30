package rest.rest;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tech.utils.readers.reader_apartamentsw;
import tech.utils.readers.reader_switchboard;
import tech.utils.readers.reader_switchboardv1;
import tech.utils.other.getAsmbl;
import tech.utils.other.actionAsmbl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping(value = "")
public class EqController {

    private final String filePath = "C:\\test specs";
    private reader_switchboard sw = new reader_switchboard();
    private reader_switchboardv1 swv1 = new reader_switchboardv1();
    private reader_apartamentsw apsw = new reader_apartamentsw();
    private String  result = "";
    private getAsmbl getAsmbl = new getAsmbl();
    private actionAsmbl updateAsmbl = new actionAsmbl();

    @RequestMapping(value = "math/switchboard", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String createsw (@RequestBody String data) throws IOException {
        System.out.println(data);
        try {
            result = sw.result(data);
        } catch (SQLException e) {e.printStackTrace();}
        catch (JSONException e) {e.printStackTrace();}
        System.out.println(result);
        return result;
    }


    @RequestMapping(value = "math/switchboardv1", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String createsw1 (@RequestBody String data) throws IOException {
        System.out.println(data);
        try {
            result = swv1.result(data);
        } catch (SQLException e) {e.printStackTrace();}
        catch (JSONException e) {e.printStackTrace();}
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "math/apartsw", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String createapsw (@RequestBody String data) throws IOException {
        System.out.println(data);
        try {
            result = apsw.result(data);
        } catch (SQLException e) {e.printStackTrace();}
        catch (JSONException e) {e.printStackTrace();}
        System.out.println(result);
        return result;
    }


    @RequestMapping(value = "math/loadfiles", method = RequestMethod.GET/*, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    public void loadfile (@RequestParam(name = "id") String fileName1, HttpServletResponse response) throws IOException {
        String fileName = "specification" + fileName1 + ".xls";
        Path file = Paths.get(filePath, fileName);
        if (Files.exists(file)){
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.setContentType("application/vnd.ms-excel");

        try {
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException e) {
            //LOG.info("Error writing file to output stream. Filename was '{}'" + fileName, e);
            throw new RuntimeException("IOError writing file to output stream");
        }
    }
}

    @RequestMapping(value = "users/getasmbl", method = RequestMethod.GET, produces = "application/json")
     public @ResponseBody String getassamblies (@RequestParam(name = "id") String id, HttpServletResponse response) throws IOException, SQLException {
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






