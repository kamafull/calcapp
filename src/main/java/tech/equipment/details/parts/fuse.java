package tech.equipment.details.parts;

public class fuse {

    private int mnf;
    private int amount = 1;
    private String series;
    private int current;

    public fuse(int amount, String series, int current) {
        this.amount = amount;
        this.series = series;
        this.current = current;
    }
}
