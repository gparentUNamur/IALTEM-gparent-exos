package be.pj.threads.workflow;

import be.pj.threads.common.Queue;
import be.pj.threads.workflow.product.Car;
import be.pj.threads.workflow.tasks.TaskFrame;
import be.pj.threads.workflow.tasks.TaskGearbox;
import be.pj.threads.workflow.tasks.TaskMotor;
import be.pj.threads.workflow.tasks.TaskWheel;

public class ComplexWorkflow {
    public static void main(String[] args) {
        Queue<Car> initialQueue = new Queue<>();
        Queue<Car> afterFrame = new Queue<>();
        Queue<Car> afterMotor = new Queue<>();
        Queue<Car> afterGearbox = new Queue<>();
        Queue<Car> afterWheels = new Queue<>();

        CarCreator creator = new CarCreator(initialQueue, 10);
        TaskFrame taskFrame1 = new TaskFrame("Frame1", 3000, initialQueue, afterFrame);
        TaskFrame taskFrame2 = new TaskFrame("Frame2", 3000, initialQueue, afterFrame);
        TaskMotor taskMotor1 = new TaskMotor("Motor1", 2000, afterFrame, afterMotor);
        TaskMotor taskMotor2 = new TaskMotor("Motor2", 2000, afterFrame, afterMotor);
        TaskMotor taskMotor3 = new TaskMotor("Motor3", 2000, afterFrame, afterMotor);
        TaskGearbox taskGearbox = new TaskGearbox("Gearbox", 1000, afterMotor, afterGearbox);
        TaskWheel taskWheel1 = new TaskWheel("Wheel1", 4000, afterGearbox, afterWheels);
        TaskWheel taskWheel2 = new TaskWheel("Wheel2", 4000, afterGearbox, afterWheels);

        new Thread(creator).start();
        new Thread(taskFrame1).start();
        new Thread(taskFrame2).start();
        new Thread(taskMotor1).start();
        new Thread(taskMotor2).start();
        new Thread(taskMotor3).start();
        new Thread(taskGearbox).start();
        new Thread(taskWheel1).start();
        new Thread(taskWheel2).start();

    }
}
