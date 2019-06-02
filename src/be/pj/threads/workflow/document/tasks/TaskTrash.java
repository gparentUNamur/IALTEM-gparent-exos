package be.pj.threads.workflow.document.tasks;

import be.pj.threads.common.DocumentQueue;
import be.pj.threads.workflow.document.DocStatus;
import be.pj.threads.workflow.document.Document;

import java.util.Map;


public class TaskTrash extends Task {

    public TaskTrash(DocumentQueue in, Map<DocStatus, DocumentQueue> out) {
        super(in, out);
    }

    @Override
    public void run() {
        while (true) {
            Document d = in.getElement();

            System.out.printf("Document n°%d will be deleted\n", d.getId());
            try {
                long dur = this.getDuration();
                System.out.println("TRASH during " + dur + " ms");
                Thread.sleep(dur);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
