package be.pj.threads.workflow.document.tasks;

import be.pj.threads.common.DocumentQueue;
import be.pj.threads.workflow.document.DocStatus;
import be.pj.threads.workflow.document.Document;

import java.util.Map;

public class TaskSend extends Task {

    public TaskSend(DocumentQueue in, Map<DocStatus, DocumentQueue> out) {
        super(in, out);
    }

    @Override
    public void run() {
        while (true) {
            Document d = in.getElement();

            System.out.printf("Document n°%d will be SEND\n", d.getId());
            try {
                long dur = this.getDuration();
                System.out.println("SEND during " + dur + " ms");
                Thread.sleep(dur);
            } catch (InterruptedException ignored) {
            }
            d.setStatus(DocStatus.BACKUP);
            out.get(DocStatus.BACKUP).addElement(d);
        }

    }
}
