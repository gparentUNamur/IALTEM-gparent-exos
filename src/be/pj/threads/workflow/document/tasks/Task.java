package be.pj.threads.workflow.document.tasks;

import be.pj.threads.common.DocumentQueue;
import be.pj.threads.workflow.document.DocStatus;

import java.util.Map;
import java.util.Random;

public abstract class Task implements Runnable {
    protected DocumentQueue in;
    protected Map<DocStatus, DocumentQueue> out;
    protected Random randomFactor = new Random();

    public Task(DocumentQueue in, Map<DocStatus, DocumentQueue> out) {
        this.in = in;
        this.out = out;
    }

    public long getDuration() {
        return Math.abs(randomFactor.nextLong()) % 10 * 1000;
    }

}
