package tech.docs;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import tech.equipment.asmbls.apartAsmbl3;
import tech.equipment.details.circuitbreaker;
import tech.utils.other.mnfBack;

import java.io.FileOutputStream;
import java.sql.*;

public class specAsmbl3 {

    HSSFWorkbook result;

    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";

    public void createspec(apartAsmbl3 sw) throws SQLException {

        HSSFWorkbook buffbook = new HSSFWorkbook();
        mnfBack mnfback = new mnfBack();
        Sheet sheet = buffbook.createSheet("Specification");
        sheet.setColumnWidth(0, 15000);
        // создаем название колонок
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Наименование");
        row.createCell(1).setCellValue("Основной параметр");
        row.createCell(2).setCellValue("Производитель");
        row.createCell(3).setCellValue("Артикул");
        row.createCell(4).setCellValue("Количество");
        row.createCell(5).setCellValue("Цена, за шт. с НДС");
        row.createCell(6).setCellValue("Ссылка на товар");


        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            String buff = "";
            //заполняем колонки вводных автоматов
            int i = 1;
            row = sheet.createRow(i);
            i++;
            row.createCell(0).setCellValue("РАЗДЕЛ 1. ВВОДНЫЕ АППАРАТЫ");
            row = sheet.createRow(i);
            i++;
            row.createCell(0).setCellValue("РАЗДЕЛ 1.1. ВВОДНЫЕ АВТОМАТИЧЕСКИЕ ВЫКЛЮЧАТЕЛИ");
            for (circuitbreaker cb : sw.getListEq_1().getListCb()) {
                row = sheet.createRow(i);
                i++;
                String sql = "SELECT * FROM circuit_breakers.circuit_breakers WHERE current = " + cb.getCurrent() + " and voltage = " + cb.getVoltage() + " and mnf =" + cb.getManufacturer() + " and series = '" + cb.getSeries()  + "';";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    row.createCell(0).setCellValue(rs.getString("description"));
                    row.createCell(1).setCellValue(rs.getString("current") + " A");
                    row.createCell(2).setCellValue(mnfback.mnfname(cb.getManufacturer()));
                    row.createCell(3).setCellValue(rs.getString("id_mnf"));
                    row.createCell(4).setCellValue(cb.getAmount() + " шт.");
                    row.createCell(5).setCellValue(rs.getInt("price") + " руб.");
                    row.createCell(6).setCellValue("aspr.tech");
                } else {
                    row.createCell(0).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
                    //sw.setAlarms("Корпус не посчитан т.к. не найдет в базе");
                }


            }
        }

        try {
            String s = "C:\\test specs\\specification" + sw.getIdorder() + ".xls";
            FileOutputStream finalFile = new FileOutputStream(s);
            buffbook.write(finalFile);
            finalFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}






