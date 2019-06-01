package be.pj.threads.workflow.tasks;

import be.pj.threads.common.Queue;
import be.pj.threads.workflow.product.Car;

public abstract class Task implements Runnable {

    protected String name;
    protected long duration;
    protected Queue<Car> in;
    protected Queue<Car> out;

    public Task(String name, long duration, Queue<Car> in, Queue<Car> out) {
        this.name = name;
        this.duration = duration;
        this.in = in;
        this.out = out;
    }
}
