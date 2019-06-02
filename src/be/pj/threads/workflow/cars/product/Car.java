package be.pj.threads.workflow.cars.product;

public class Car {
    private boolean motor = false;
    private boolean frame = false;
    private boolean wheels = false;
    private boolean gearbox = false;
    private int id;

    public Car(int id) {
        this.id = id;
    }

    public void setMotor() {
        this.motor = true;
        this.printInfo();
    }

    public void setFrame() {
        this.frame = true;
        this.printInfo();
    }

    public void setWheels() {
        this.wheels = true;
        this.printInfo();
    }

    public void setGearbox() {
        this.gearbox = true;
        this.printInfo();
    }

    public void printInfo() {
        String motor = this.motor ? "motor" : "no motor";
        String frame = this.frame ? "frame" : "no frame";
        String wheels = this.wheels ? "wheels" : "no wheels";
        String gearbox = this.gearbox ? "gearbox" : "no gearbox";
        System.out.printf("Car n°%d has %s,%s,%s,%s\n", this.id, motor, frame, wheels, gearbox);
    }
}
