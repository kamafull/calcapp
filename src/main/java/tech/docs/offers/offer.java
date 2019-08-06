package tech.docs.offers;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.equipment.asmbls.apartAsmbl3;
import tech.maths.asmbl3.calcAsmbl;
import tech.maths.asmbl3.pricing;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

@Data
public class offer {


    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";
    private JSONObject json;
    private String object;
    private String customer;
    private String basis;
    private JSONArray array;
    private int price;
    private int id;
    private String name;
    private int amount;

    public void create(String data) throws Exception {
        HSSFWorkbook buffbook = new HSSFWorkbook(new FileInputStream("C:\\base docs\\шаблон ткп.xls"));
        Row row;
        Sheet sheet = buffbook.getSheet("offer");
        JSONObject json = new JSONObject(data);
        object = json.getString("object");
        customer = json.getString("customer");
        basis = json.getString("basis");
        array = json.getJSONArray("array_asmbls");

        row = sheet.getRow(9);
        row.createCell(3).setCellValue(new Random().nextInt(99999));
        row = sheet.getRow(10);
        row.createCell(1).setCellValue(object);
        row = sheet.getRow(11);
        row.createCell(1).setCellValue(customer);
        row = sheet.getRow(12);
        row.createCell(1).setCellValue(basis);


        for (int i = 0; i < array.length(); i++) {

            json = array.getJSONObject(i);
            id = json.getInt("idorder");
            try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
                String sql = "SELECT * FROM circuit_breakers.saves_cabinets WHERE id = " + id + "';";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    price = rs.getInt("price");
                    name = rs.getString("name");
                }
                amount = json.getInt("amount");
                row = sheet.createRow(23 + i);
                row.createCell(1).setCellValue(id);
                row.createCell(2).setCellValue(name);
                row.createCell(4).setCellValue(price);
                row.createCell(4).setCellValue(price*amount);

            }


            String s = "C:\\test specs\\aspr.tech offer id#" + id + ".xls";
            FileOutputStream finalFile = new FileOutputStream(s);
            buffbook.write(finalFile);
            finalFile.close();


        }

    }
}
