package tech.equipment.details.parts;

import lombok.Data;

@Data
public class body {

    private int manufacturer;
    private String series;
    private int amount = 1;
    private String size;
    private int type;
    private int ip;

    public body(int manufacturer, String series, String size, int ip, int type, int amount)  {
        this.manufacturer = manufacturer;
        this.series = series;
        this.amount = amount;
        this.size = size;
        this.type = type;
        this.ip = ip;
    }

}
