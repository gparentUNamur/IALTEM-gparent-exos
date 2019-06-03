package be.pj.patterns.visitor.visitable;

public abstract class Building implements Visitable {
    protected int id;
    protected String type;
    protected int gazLevel;
    protected int waterLevel;
    protected int electricLevel;


    public Building(int id, int gazLevel, int waterLevel, int electricLevel) {
        this.id = id;
        this.gazLevel = gazLevel;
        this.waterLevel = waterLevel;
        this.electricLevel = electricLevel;
    }

    public int getId() {
        return id;
    }

    public int getGazLevel() {
        return gazLevel;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getElectricLevel() {
        return electricLevel;
    }


    public String getType() {
        return this.type;
    }


}
