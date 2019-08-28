package rest.rest;


import org.springframework.web.bind.annotation.*;
import tech.docs.offers.offer;
import tech.docs.specifications.specAsmbl3;
import tech.utils.builders.builderAsmbl3;

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
    builderAsmbl3 builderAsmbl3 = new builderAsmbl3();
    offer offer = new offer();
    specAsmbl3 specAsmbl3 = new specAsmbl3();

    //создать спецификацию
    @RequestMapping(value = "/create/specification", method = RequestMethod.POST/*, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    public int createspec (@RequestBody String data, HttpServletResponse response) throws Exception {

        specAsmbl3.createspec(builderAsmbl3.resultAsmbl(data));

        return specAsmbl3.getId();
    }


    //скачать спецификацию
    @RequestMapping(value = "/download/specification", method = RequestMethod.GET/*, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    public void downloadspec (@RequestParam(name = "id") String fileName1, HttpServletResponse response) throws IOException {
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
    @RequestMapping(value = "/create/offer", method = RequestMethod.POST/*, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    public int createoffer (@RequestBody String data, HttpServletResponse response) throws Exception {
        offer.create(data);

        return offer.getId();
    }

    @RequestMapping(value = "/download/offer", method = RequestMethod.GET/*, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    public void downloadoffer (@RequestParam(name = "id") String fileName1, HttpServletResponse response) throws IOException {
        String fileName = "aspr.tech offer id#" + fileName1 + ".xls";
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
