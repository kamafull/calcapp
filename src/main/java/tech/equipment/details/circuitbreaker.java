package tech.equipment.details;

import lombok.Data;

@Data
public class circuitbreaker {

    private int current;
    private int voltage;
    private int manufacturer;
    private String id_manufacturer;
    private String series;
    private int serias_type;
    private int poles;
    private String breaking_capacity;
    private String breaking_capacity_code;
    private int amount = 1;

    public circuitbreaker(int current, int voltage, int manufacturer, int poles, String series, String breaking_capacity, String breaking_capacity_code, int amount) {
        this.current = current;
        this.voltage = voltage;
        this.manufacturer = manufacturer;
        this.poles = poles;
        this.breaking_capacity = breaking_capacity;
        this.breaking_capacity_code = breaking_capacity_code;
        this.amount = amount;
        this.series = series;
    }
}
