package rest.rest;


import org.springframework.web.bind.annotation.*;
import tech.docs.offers.offer;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping(value = "")
public class LoadFilesControlletV1 {

    private final String filePath = "C:\\test specs";
    offer offer = new offer();

    //скачать спецификацию
    @RequestMapping(value = "math/loadspec", method = RequestMethod.GET/*, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    public void loadspec (@RequestParam(name = "id") String fileName1, HttpServletResponse response) throws IOException {
        String fileName = "aspr.tech specification id#" + fileName1 + ".xls";
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

    //скачать ТКП

    @RequestMapping(value = "math/loadoffer", method = RequestMethod.GET/*, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    public void loadoffer (@RequestBody String data, HttpServletResponse response) throws Exception {
        offer.create(data);
        String fileName = "aspr.tech offer id#" + offer.getId() + ".xls";
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

}
