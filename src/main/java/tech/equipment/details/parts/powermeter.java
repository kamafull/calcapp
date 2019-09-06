package tech.equipment.details.parts;

import lombok.Data;

@Data
public class powermeter {

    private int manufacturer;
    private String id_manufacturer;
    private int voltage;
    private int current;
    private int tariff;
    private int amount = 1;

    public powermeter(int manufacturer, int voltage, int current, int tariff, int amount) {
        this.manufacturer = manufacturer;
        this.voltage = voltage;
        this.current = current;
        this.tariff = tariff;
        this.amount = amount;
    }
}
