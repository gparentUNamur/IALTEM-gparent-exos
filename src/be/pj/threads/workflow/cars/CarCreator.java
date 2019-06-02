package be.pj.threads.workflow.cars;

import be.pj.threads.common.Queue;
import be.pj.threads.workflow.cars.product.Car;

public class CarCreator implements Runnable {
    private Queue<Car> queue;
    private int nbCar;

    public CarCreator(Queue<Car> q, int numberOfCar) {
        this.queue = q;
        this.nbCar = numberOfCar;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < this.nbCar) {
            this.queue.addElement(new Car(i));
            System.err.printf("Car n°%d entered in the system\n", i);
            i++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
