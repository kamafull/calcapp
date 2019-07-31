package tech.maths.asmbl3;

import tech.equipment.details.*;
import tech.utils.readers.listEq;


import java.sql.*;


public class pricing {
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
                        System.out.println(rs.getString("description"));
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
                    System.out.println(rs.getString("description"));
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
                    System.out.println(rs.getString("description"));
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
                    System.out.println(rs.getString("description"));
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
                System.out.println(rs.getString("description"));
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


      /*public int price(ArrayList<circuitbreaker> listcb) {
        int price = 0;
        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            for (circuitbreaker cb : listcb) {
                String sql = "SELECT * FROM circuit_breakers.circuit_breakers WHERE current = " + cb.getCurrent() + " and voltage = " + cb.getVoltage() + " and manufacturer =" + cb.getManufacturer() + ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    price += rs.getInt("price");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }

    public int price(circuitbreaker cb) throws SQLException {
        int price = 0;
        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
            String sql = "SELECT * FROM circuit_breakers.circuit_breakers WHERE current = " + cb.getCurrent() + " and voltage = " + cb.getVoltage() + " and manufacturer =" + cb.getManufacturer() + ";";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                price += rs.getInt("price");
            }
        }
        return price;
    }

    public int price(enclosure ecs) throws SQLException {
        int price = 0;
        int ip = 54;
        try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
           String sql = "SELECT * FROM circuit_breakers.enclosures WHERE size = " + "'" + ecs.getSize() + "'" +" and ip = " + ecs.getIp() + " and manufacturer =" + ecs.getManufacturer() + ";";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                price += rs.getInt("price");
            }
            else {
                if (ecs.getIp() == 54) ip = 55;
                else ip = 54;
                sql = "SELECT * FROM circuit_breakers.enclosures WHERE size = " + "'" + ecs.getSize() + "'" +" and ip = " + ip + " and manufacturer =" + ecs.getManufacturer() + ";";
                rs = stat.executeQuery(sql);
                if (rs.next()) {
                    price += rs.getInt("price");
                }
            }
            return price;
        }
    }

        public int price (powermeter pmeter) throws SQLException {
            int price = 0;
            try (Connection con = DriverManager.getConnection(url, user, password); Statement stat = con.createStatement()) {
                String sql = "SELECT * FROM circuit_breakers.power_meters WHERE voltage = " + pmeter.getVoltage() + " and need_net = " + pmeter.getNeed_net() + " and manufacturer =" + pmeter.getManufacturer() + ";";
                ResultSet rs = stat.executeQuery(sql);
                if (rs.next()) {
                    price += rs.getInt("price");
                }
                return price;

            }

        }
*/