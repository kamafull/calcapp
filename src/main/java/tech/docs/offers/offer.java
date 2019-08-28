package tech.docs.offers;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.utils.other.priceforofferbytype;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
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
    private Date date = new Date();
    int id_order;
    int type;
    String save_json ="";
    priceforofferbytype priceforofferbytype = new priceforofferbytype();

    public void create(String data) throws Exception {
       // System.out.println("1 этап");
        id = new Random().nextInt(99999);
        int result = 0;
        int k = 0;
        HSSFWorkbook buffbook = new HSSFWorkbook(new FileInputStream("C:\\base docs\\шаблон ткп.xls"));
        Row row;
        Sheet sheet = buffbook.getSheet("offer");
        JSONObject json = new JSONObject(data);
        object = json.getString("object");
        customer = json.getString("customer");
        basis = json.getString("basis");
        array = json.getJSONArray("array_asmbls");
        row = sheet.createRow(9);
        row.createCell(2).setCellValue("aspr.tech " + date.toString());
        row = sheet.createRow(11);
        row.createCell(0).setCellValue("Объект:");
        row.createCell(1).setCellValue(object);
        row = sheet.createRow(12);
        row.createCell(0).setCellValue("Заказчик:");
        row.createCell(1).setCellValue(customer);
        row = sheet.createRow(13);
        row.createCell(0).setCellValue("Основание:");
        row.createCell(1).setCellValue(basis);

        for (int i = 0; i < array.length(); i++) {

            json = array.getJSONObject(i);
            id_order = json.getInt("idorder");
            try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
                String sql = "SELECT * FROM circuit_breakers.saves_cabinets WHERE id = " + id_order + ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    type = rs.getInt("type");
                    name = rs.getString("name");
                    save_json = rs.getString("save_json");
                }
                price = priceforofferbytype.price(type, save_json);
                amount = json.getInt("amount");
                row = sheet.createRow(16 + i);
                row.createCell(0).setCellValue(i+1);
                row.createCell(1).setCellValue(id_order);
                row.createCell(2).setCellValue(name);
                row.createCell(3).setCellValue(amount);
                row.createCell(4).setCellValue(price);
                result = amount*price + result;
                row.createCell(5).setCellValue(amount*price);
            }
            k=k+i;
        }
        k++;
        row = sheet.createRow(15+k+1);
        row.createCell(4).setCellValue("Итого, вкл. НДС 20%");
        row.createCell(5).setCellValue(result);
        row = sheet.createRow(15+k+2);
        row.createCell(4).setCellValue("В том числе НДС 20%");
        row.createCell(5).setCellValue((Integer)(result/6));
        row = sheet.createRow(15+k+5);
        row.createCell(0).setCellValue("Условия доставки – самовывоз");
        row = sheet.createRow(15+k+7);
        row.createCell(0).setCellValue("Условия оплаты - 100% предоплата.");
        row = sheet.createRow(15+k+9);
        row.createCell(0).setCellValue("Вы можете скачать спецификацию и пересчитать на любого производителя одним кликом.");
        row = sheet.createRow(15+k+12);
        row.createCell(0).setCellValue("Подготовил:");
        row = sheet.createRow(15+k+13);
        row.createCell(0).setCellValue("Менеджер проекта");
        row.createCell(4).setCellValue("Кравченко А.Ю.");

        String s = "C:\\test specs\\aspr.tech offer id#" + id + ".xls";
        FileOutputStream finalFile = new FileOutputStream(s);
        buffbook.write(finalFile);
        finalFile.close();

    }
}
