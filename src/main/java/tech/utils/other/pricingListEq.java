package tech.utils.other;

import tech.equipment.details.*;
import tech.equipment.details.listEq;
import java.sql.*;

public class pricingListEq {
    String url = "jdbc:mysql://localhost:3306/circuit_breakers?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "1234";

    public int price (listEq list){
        int price = 0;
        String bd_pmeter = "";
        bd_pmeter = "asmbl3_pmeters";

        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
        for (circuitbreaker cb : list.getListCb()){
                    String sql = "SELECT * FROM circuit_breakers.circuit_breakers WHERE current = " + cb.getCurrent() + " and voltage = " + cb.getVoltage() + " and mnf =" + cb.getManufacturer() + " and series ='" + cb.getSeries() + "' and poles =" + cb.getPoles() + " and bct ='" + cb.getBreaking_capacity_code()  + "';";
                    ResultSet rs = stat.executeQuery(sql);
                    if (rs.next()) {
                        price += rs.getInt("price")*cb.getAmount();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            for (powermeter pm : list.getListPmeter()){
                String sql = "SELECT * FROM circuit_breakers."+ bd_pmeter +  " WHERE current = " + pm.getCurrent() + " and voltage = " + pm.getVoltage() + " and mnf =" + pm.getManufacturer() + " and tariff =" + pm.getTariff() +  ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    price += rs.getInt("price")*pm.getAmount();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            for (rcd rcd : list.getListRcd()){
                String sql = "SELECT * FROM circuit_breakers.rcd WHERE current = " + rcd.getCurrent() + " and voltage = " + rcd.getVoltage() + " and mnf =" + rcd.getManufacturer() + " and difcurrent =" + rcd.getResidual_current() +  ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    price += rs.getInt("price")*rcd.getAmount();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            for (rcbo rcbo : list.getListRcbo()){
                String sql = "SELECT * FROM circuit_breakers.rcbo WHERE current = " + rcbo.getCurrent() + " and voltage = " + rcbo.getVoltage() + " and mnf =" + rcbo.getManufacturer() + " and difcurrent =" + rcbo.getResidual_current() +  ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    price += rs.getInt("price")*rcbo.getAmount();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            String sql = "SELECT * FROM circuit_breakers.asmbl3_ecs WHERE id = " + list.getEcs_apart() +  ";";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                price += rs.getInt("price");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }

    public int price (circuitbreaker cb) throws SQLException{
        int price = 0;
        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
                String sql = "SELECT * FROM circuit_breakers.circuit_breakers WHERE current = " + cb.getCurrent() + " and voltage = " + cb.getVoltage() + " and mnf =" + cb.getManufacturer() + ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    price += rs.getInt("price");
                }
            }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;

    }


}


