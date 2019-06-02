package be.pj.threads.workflow.cars.tasks;

import be.pj.threads.common.Queue;
import be.pj.threads.workflow.cars.product.Car;

public class TaskFrame extends Task {
    public TaskFrame(String name, long duration, Queue<Car> in, Queue<Car> out) {
        super(name, duration, in, out);
    }

    @Override
    public void run() {
        while (true) {
            Car c = this.in.getElement();

            try {
                Thread.sleep(this.duration);
            } catch (InterruptedException ignored) {
            }
            c.setFrame();
            this.out.addElement(c);
        }
    }
}
