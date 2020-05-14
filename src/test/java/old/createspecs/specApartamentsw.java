package old.createspecs;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import tech.equipment.asmbls.apartAsmbl3;
import tech.equipment.details.parts.circuitbreaker;
import tech.utils.other.mnfBack;

import java.io.FileOutputStream;
import java.sql.*;

public class specApartamentsw {

    HSSFWorkbook result;

    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";

    public void createspec(apartAsmbl3 sw) throws SQLException {

        HSSFWorkbook buffbook = new HSSFWorkbook();
        mnfBack mnfback = new mnfBack();
        Sheet sheet = buffbook.createSheet("Specification");
        // создаем название колонок
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Наименование");
        row.createCell(1).setCellValue("Производитель");
        row.createCell(2).setCellValue("Артикул");
        row.createCell(3).setCellValue("Основной параметр");
        row.createCell(4).setCellValue("Количество");
        row.createCell(5).setCellValue("Цена, за шт. с НДС");
        row.createCell(6).setCellValue("Ссылка на товар");

        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            String buff = "";
            //заполняем колонки вводных автоматов
            row = sheet.createRow(1);
            row.createCell(1).setCellValue("РАЗДЕЛ 1. ВВОДНЫЕ АППАРАТЫ");
            row = sheet.createRow(2);
            String sql = "SELECT * FROM circuit_breakers.circuit_breakers WHERE current = " + sw.getIncb().getCurrent() + " and voltage = " + sw.getIncb().getVoltage() + " and manufacturer =" + sw.getIncb().getManufacturer() + " and id_pes = 0;";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                row.createCell(0).setCellValue(rs.getString("description"));
                row.createCell(1).setCellValue(mnfback.mnfname(sw.getIncb().getManufacturer()));
                row.createCell(2).setCellValue(rs.getString("id_manufacturer"));
                row.createCell(3).setCellValue(rs.getInt("current" ) + " А");
                row.createCell(4).setCellValue(1);
                row.createCell(5).setCellValue(rs.getInt("price"));
                buff = "http://www.elektro-portal.com/product/show/" + rs.getString("id_pes");
                row.createCell(6).setCellValue(buff);
            }
            else {
                row.createCell(1).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
                //sw.setAlarms("Корпус не посчитан т.к. не найдет в базе");
            }
            //заполняем колонки счетчиков
            row = sheet.createRow(3);
            row.createCell(1).setCellValue("РАЗДЕЛ 2. СИСТЕМА ИЗМЕРЕНИЙ");
            row = sheet.createRow(4);
            int a = 0;
            if (sw.getPmeter_aparttype() == 1) a = 0;
                    else if (sw.getPmeter_aparttype() == 2) a = 1;
            sql = "SELECT * FROM circuit_breakers.power_meters WHERE manufacturer =" + sw.getPmeter_mnf() + " and need_net =" + a +  ";";
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                row.createCell(0).setCellValue(rs.getString("description"));
                row.createCell(1).setCellValue(mnfback.mnfname(sw.getPmeter_mnf()));
                row.createCell(2).setCellValue(rs.getString("id_manufacturer"));
                row.createCell(3).setCellValue(rs.getInt("voltage") + " В" );
                row.createCell(4).setCellValue(1);
                row.createCell(5).setCellValue(rs.getInt("price"));
                buff = "http://www.elektro-portal.com/product/show/" + rs.getString("id_pes");
                row.createCell(6).setCellValue(buff);
            }
            else {
                row.createCell(1).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
                //sw.setAlarms("Корпус не посчитан т.к. не найдет в базе");
            }
            //заполняем колонку отходящих автоматов
            row = sheet.createRow(5);
            row.createCell(1).setCellValue("РАЗДЕЛ 3. ГРУППОВЫЕ АВТОМАТЫ");
            row = sheet.createRow(6);
            int k = 6;
            int i = 0;
            for (circuitbreaker c : sw.getList_outcb()){
                sql = "SELECT * FROM circuit_breakers.circuit_breakers WHERE current = " + c.getCurrent() + " and voltage = " + c.getVoltage() + " and manufacturer =" + c.getManufacturer() + " and id_pes = 0;";
                rs = stat.executeQuery(sql);
                if (rs.next()) {
                    row.createCell(0).setCellValue(rs.getString("description"));
                    row.createCell(1).setCellValue(mnfback.mnfname(c.getManufacturer()));
                    row.createCell(2).setCellValue(rs.getString("id_manufacturer"));
                    row.createCell(3).setCellValue(rs.getInt("current") + " А");
                    row.createCell(4).setCellValue(1);
                    row.createCell(5).setCellValue(rs.getInt("price"));
                    buff = "http://www.elektro-portal.com/product/show/" + rs.getString("id_pes");
                    row.createCell(6).setCellValue(buff);
                }
                else {
                    row.createCell(1).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
                    //sw.setAlarms("Корпус не посчитан т.к. не найдет в базе");
                }
                i++;
                row = sheet.createRow(6 + i);
            }
            //заполняем колонку корпусов
            row = sheet.createRow(k+i);
            row.createCell(1).setCellValue("РАЗДЕЛ 4. КОМПЛЕКТУЮЩИЕ КОРПУСА ШКАФА");
            row = sheet.createRow(k+i+1);
            int id_buf = 13;
            int id_buf_mnf = 4;
            if (sw.getEcs_aparttype() == 1) {
                id_buf = 67;
                id_buf_mnf = 4;
            }
            else if(sw.getEcs_aparttype() == 2) {
                id_buf = 70;
                id_buf_mnf = 3;
            }
            sql = "SELECT * FROM circuit_breakers.enclosures WHERE id = " + id_buf + ";";
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                row.createCell(0).setCellValue(rs.getString("description"));
                row.createCell(1).setCellValue(mnfback.mnfname(id_buf_mnf));
                row.createCell(2).setCellValue(rs.getString("id_manufacturer"));
                row.createCell(3).setCellValue(rs.getString("size") + " ВxШxГ");
                row.createCell(4).setCellValue(1);
                row.createCell(5).setCellValue(rs.getInt("price"));
                buff = "http://www.elektro-portal.com/product/show/" + rs.getString("id_pes");
                row.createCell(6).setCellValue(buff);
            }
            //делаем шины, провода и тд
            row = sheet.createRow(k+i+2);
            row.createCell(1).setCellValue("РАЗДЕЛ 5. СИСТЕМА СОЕДИНЕНИЙ");
            row = sheet.createRow(k+i+3);
            row.createCell(0).setCellValue("Провод монтажный");
            row.createCell(1).setCellValue("");
            row.createCell(2).setCellValue("");
            row.createCell(3).setCellValue("Cu");
            row.createCell(4).setCellValue(3*(sw.getList_outcb().size()));
            row.createCell(5).setCellValue(80);
            buff = ("http://www.elektro-portal.com/category/products/shiny-mednye-shmt");
            row.createCell(6).setCellValue(buff);
            //раздел работа
            row = sheet.createRow(k+i+4);
            row.createCell(1).setCellValue("РАЗДЕЛ 6. МОНТАЖНЫЕ РАБОТЫ");
            row = sheet.createRow(k+i+5);
            row.createCell(0).setCellValue("Работы");
            row.createCell(1).setCellValue("Промэлектросервис НКУ");
            row.createCell(2).setCellValue("");
            row.createCell(3).setCellValue("");
            row.createCell(4).setCellValue(14*(sw.getList_outcb().size()));
            row.createCell(5).setCellValue("275 руб/час");
            row.createCell(6).setCellValue("");

        }
        try {
            String s = "C:\\test specs\\specification" + sw.getIdorder() + ".xls";
            FileOutputStream finalFile = new FileOutputStream(s);
            buffbook.write(finalFile);
            finalFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //result = buffbook;
    }



}
