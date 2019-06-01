package be.pj.threads.workflow.tasks;

import be.pj.threads.common.Queue;
import be.pj.threads.workflow.product.Car;

public class TaskWheel extends Task {
    public TaskWheel(String name, long duration, Queue<Car> in, Queue<Car> out) {
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
            c.setWheels();
            this.out.addElement(c);
        }
    }
}
