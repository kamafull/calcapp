package tech.docs.specifications;

import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import tech.equipment.asmbls.apartAsmbl3;
import tech.equipment.details.parts.circuitbreaker;
import tech.equipment.details.parts.powermeter;
import tech.equipment.details.parts.rcbo;
import tech.equipment.details.parts.rcd;
import tech.utils.other.mnfBack;

import java.io.FileOutputStream;
import java.sql.*;
@Data
public class specAsmbl3 {

    HSSFWorkbook result;
    int id;
    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";

    public void createspec(apartAsmbl3 sw) throws SQLException {

        mnfBack mnfback = new mnfBack();
        HSSFWorkbook buffbook = new HSSFWorkbook();
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
            row.createCell(0).setCellValue("РАЗДЕЛ 1. ВВОДНЫЕ АППАРАТЫ");
            i++;
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
                }


            }
            for (rcd rcd : sw.getListEq_1().getListRcd()) {
                row = sheet.createRow(i);
                i++;
                String sql = "SELECT * FROM circuit_breakers.rcd WHERE current = " + rcd.getCurrent() + " and voltage = " + rcd.getVoltage() + " and mnf =" + rcd.getManufacturer() + " and difcurrent =" + rcd.getResidual_current() + ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    row.createCell(0).setCellValue(rs.getString("description"));
                    row.createCell(1).setCellValue(rs.getString("difcurrent") + " мA");
                    row.createCell(2).setCellValue(mnfback.mnfname(rcd.getManufacturer()));
                    row.createCell(3).setCellValue(rs.getString("id_mnf"));
                    row.createCell(4).setCellValue(rcd.getAmount() + " шт.");
                    row.createCell(5).setCellValue(rs.getInt("price") + " руб.");
                    row.createCell(6).setCellValue("aspr.tech");
                } else {
                    row.createCell(0).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
                }
            }

                for (rcbo rcbo : sw.getListEq_1().getListRcbo()) {
                    row = sheet.createRow(i);
                    i++;
                    String sql = "SELECT * FROM circuit_breakers.rcbo WHERE current = " + rcbo.getCurrent() + " and voltage = " + rcbo.getVoltage() + " and mnf =" + rcbo.getManufacturer() + " and difcurrent =" + rcbo.getResidual_current() +  ";";
                    ResultSet rs = stat.executeQuery(sql);
                    if (rs.next()) {
                        row.createCell(0).setCellValue(rs.getString("description"));
                        row.createCell(1).setCellValue(rs.getString("difcurrent") + " мA");
                        row.createCell(2).setCellValue(mnfback.mnfname(rcbo.getManufacturer()));
                        row.createCell(3).setCellValue(rs.getString("id_mnf"));
                        row.createCell(4).setCellValue(rcbo.getAmount() + " шт.");
                        row.createCell(5).setCellValue(rs.getInt("price") + " руб.");
                        row.createCell(6).setCellValue("aspr.tech");
                    } else {
                        row.createCell(0).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
                    }

            }

            for (powermeter pm  : sw.getListEq_1().getListPmeter()) {
                row = sheet.createRow(i);
                i++;
                String sql = "SELECT * FROM circuit_breakers.asmbl3_pmeters WHERE current = " + pm.getCurrent() + " and voltage = " + pm.getVoltage() + " and mnf =" + pm.getManufacturer() + " and tariff =" + pm.getTariff() +  ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    row.createCell(0).setCellValue(rs.getString("description"));
                    row.createCell(1).setCellValue(rs.getString("current") + " A");
                    row.createCell(2).setCellValue(mnfback.mnfname(pm.getManufacturer()));
                    row.createCell(3).setCellValue(rs.getString("id_mnf"));
                    row.createCell(4).setCellValue(pm.getAmount() + " шт.");
                    row.createCell(5).setCellValue(rs.getInt("price") + " руб.");
                    row.createCell(6).setCellValue("aspr.tech");
                } else {
                    row.createCell(0).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
                }

            }


            row = sheet.createRow(i);
            row.createCell(0).setCellValue("РАЗДЕЛ 2. ГРУППОВЫЕ АППАРАТЫ");
            i++;
            for (circuitbreaker cb : sw.getListEq_2().getListCb()) {
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
                }


            }
            for (rcd rcd : sw.getListEq_2().getListRcd()) {
                row = sheet.createRow(i);
                i++;
                String sql = "SELECT * FROM circuit_breakers.rcd WHERE current = " + rcd.getCurrent() + " and voltage = " + rcd.getVoltage() + " and mnf =" + rcd.getManufacturer() + " and difcurrent =" + rcd.getResidual_current() + ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    row.createCell(0).setCellValue(rs.getString("description"));
                    row.createCell(1).setCellValue(rs.getString("current") + " A");
                    row.createCell(2).setCellValue(mnfback.mnfname(rcd.getManufacturer()));
                    row.createCell(3).setCellValue(rs.getString("id_mnf"));
                    row.createCell(4).setCellValue(rcd.getAmount() + " шт.");
                    row.createCell(5).setCellValue(rs.getInt("price") + " руб.");
                    row.createCell(6).setCellValue("aspr.tech");
                } else {
                    row.createCell(0).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
                }
            }

            for (rcbo rcbo : sw.getListEq_2().getListRcbo()) {
                row = sheet.createRow(i);
                i++;
                String sql = "SELECT * FROM circuit_breakers.rcbo WHERE current = " + rcbo.getCurrent() + " and voltage = " + rcbo.getVoltage() + " and mnf =" + rcbo.getManufacturer() + " and difcurrent =" + rcbo.getResidual_current() +  ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    row.createCell(0).setCellValue(rs.getString("description"));
                    row.createCell(1).setCellValue(rs.getString("current") + " A");
                    row.createCell(2).setCellValue(mnfback.mnfname(rcbo.getManufacturer()));
                    row.createCell(3).setCellValue(rs.getString("id_mnf"));
                    row.createCell(4).setCellValue(rcbo.getAmount() + " шт.");
                    row.createCell(5).setCellValue(rs.getInt("price") + " руб.");
                    row.createCell(6).setCellValue("aspr.tech");
                } else {
                    row.createCell(0).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");

                }

            }

            for (powermeter pm  : sw.getListEq_2().getListPmeter()) {
                row = sheet.createRow(i);
                i++;
                String sql = "SELECT * FROM circuit_breakers.asmbl3_pmeters WHERE current = " + pm.getCurrent() + " and voltage = " + pm.getVoltage() + " and mnf =" + pm.getManufacturer() + " and tariff =" + pm.getTariff() +  ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    row.createCell(0).setCellValue(rs.getString("description"));
                    row.createCell(1).setCellValue(rs.getString("current") + " A");
                    row.createCell(2).setCellValue(mnfback.mnfname(pm.getManufacturer()));
                    row.createCell(3).setCellValue(rs.getString("id_mnf"));
                    row.createCell(4).setCellValue(pm.getAmount() + " шт.");
                    row.createCell(5).setCellValue(rs.getInt("price") + " руб.");
                    row.createCell(6).setCellValue("aspr.tech");
                } else {
                    row.createCell(0).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
                }

            }


            row = sheet.createRow(i);
            row.createCell(0).setCellValue("РАЗДЕЛ 3. КОМПЛЕКТУЮЩИЕ ШКАФА");
            i++;
            row = sheet.createRow(i);
            i++;
            String sql = "SELECT * FROM circuit_breakers.asmbl3_ecs WHERE id = " + sw.getListEq_1().getEcs_apart() +  ";";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                row.createCell(0).setCellValue(rs.getString("description"));
                row.createCell(1).setCellValue("");
                row.createCell(2).setCellValue(mnfback.mnfname(rs.getInt("mnf")));
                row.createCell(3).setCellValue(rs.getString("id_mnf"));
                row.createCell(4).setCellValue("1 шт.");
                row.createCell(5).setCellValue(rs.getInt("price") + " руб.");
                row.createCell(6).setCellValue("aspr.tech");
            } else {
                row.createCell(0).setCellValue("ОТСУТСТВУЕТ В БАЗЕ ДАННЫХ");
            }


            }




        try {
            String s = "C:\\test specs\\aspr.tech specification id#" + sw.getIdorder() + ".xls";
            FileOutputStream finalFile = new FileOutputStream(s);
            buffbook.write(finalFile);
            finalFile.close();
            id = sw.getIdorder();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}






