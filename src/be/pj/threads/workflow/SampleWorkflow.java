package be.pj.threads.workflow;

import be.pj.threads.common.Queue;
import be.pj.threads.workflow.product.Car;
import be.pj.threads.workflow.tasks.TaskFrame;
import be.pj.threads.workflow.tasks.TaskGearbox;
import be.pj.threads.workflow.tasks.TaskMotor;
import be.pj.threads.workflow.tasks.TaskWheel;

public class SampleWorkflow {
    public static void main(String[] args) {
        Queue<Car> initialQueue = new Queue<>();
        Queue<Car> afterFrame = new Queue<>();
        Queue<Car> afterMotor = new Queue<>();
        Queue<Car> afterGearbox = new Queue<>();
        Queue<Car> afterWheels = new Queue<>();

        CarCreator creator = new CarCreator(initialQueue, 10);
        TaskFrame taskFrame = new TaskFrame("Frame", 3000, initialQueue, afterFrame);
        TaskMotor taskMotor = new TaskMotor("Motor", 2000, afterFrame, afterMotor);
        TaskGearbox taskGearbox = new TaskGearbox("Gearbox", 1000, afterMotor, afterGearbox);
        TaskWheel taskWheel = new TaskWheel("Wheel", 4000, afterGearbox, afterWheels);

        new Thread(creator).start();
        new Thread(taskFrame).start();
        new Thread(taskMotor).start();
        new Thread(taskGearbox).start();
        new Thread(taskWheel).start();
    }
}
