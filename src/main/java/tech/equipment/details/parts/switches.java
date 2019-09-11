package tech.equipment.details.parts;

public class switches {

    private int current;
    private int poles;
    private int reverse;
    private String series;
    private int amount = 1;

    public switches(int current, int poles, int reverse, String series, int amount) {
        this.current = current;
        this.poles = poles;
        this.reverse = reverse;
        this.series = series;
        this.amount = amount;
    }

}
