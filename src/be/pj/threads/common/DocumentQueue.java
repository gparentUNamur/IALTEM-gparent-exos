package be.pj.threads.common;

import be.pj.threads.workflow.document.DocStatus;
import be.pj.threads.workflow.document.Document;

import java.util.ArrayList;

public class DocumentQueue {

    private ArrayList<Document> queue = new ArrayList<>();
    private DocStatus status;

    public DocumentQueue(DocStatus ds) {
        this.status = ds;
    }

    public synchronized void addElement(Document d) {
        this.queue.add(d);
        notifyAll();
    }

    public synchronized Document getElement() {
        if (this.queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        return this.queue.remove(0);
    }

    public DocStatus getStatus() {
        return this.status;
    }

}
