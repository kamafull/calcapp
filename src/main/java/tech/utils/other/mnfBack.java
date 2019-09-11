package tech.utils.other;

public class mnfBack {

    public String mnfname (int id_mnf){
        String mnfname = "";
        if (id_mnf == 1) mnfname = "Schneider Electric";
        else if (id_mnf == 2) mnfname = "DEKraft";
        else if (id_mnf == 3) mnfname = "IEK";
        else if (id_mnf == 4) mnfname = "TDM";
        else if (id_mnf == 5) mnfname = "КЭАЗ";
        else if (id_mnf == 6) mnfname = "ABB";
        else if (id_mnf == 7) mnfname = "EKF";
        else if (id_mnf == 51) mnfname = "МСА";
        else if (id_mnf == 52) mnfname = "БЭТ";
        else if (id_mnf == 53) mnfname = "ФАБЕР";
        else if (id_mnf == 81) mnfname = "НЕВА";
        else if (id_mnf == 82) mnfname = "Меркурий";
        else if (id_mnf == 83) mnfname = "Альфа";
        else if (id_mnf == 84) mnfname = "Ленэлектро";
        else if (id_mnf == 85) mnfname = "ЛЭМЗ";
        else if (id_mnf == 86) mnfname = "IEK Generica";
        else if (id_mnf == 87) mnfname = "Chint";
        else if (id_mnf == 88) mnfname = "Корнеевский завод низковольной аппаратуры";

        return mnfname;
    }


}
