package tech.equipment.details;

import lombok.Data;

@Data
public class enclosure {

    private int manufacturer;
    private String size;
    private int ip;
    private int amount_doors;
    private int need_plate;
    private int need_base;

    public enclosure(int manufacturer, String size, int ip, int need_plate, int need_base) {
        this.manufacturer = manufacturer;
        this.size = size;
        this.ip = ip;
        this.need_base = need_base;
        this.need_plate = need_plate;
    }


}
