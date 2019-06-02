package be.pj.threads.workflow.document.tasks;

import be.pj.threads.common.DocumentQueue;
import be.pj.threads.workflow.document.DocStatus;
import be.pj.threads.workflow.document.Document;

import java.util.Map;

public class TaskBill extends Task {


    public TaskBill(DocumentQueue in, Map<DocStatus, DocumentQueue> out) {
        super(in, out);
    }

    @Override
    public void run() {
        while (true) {
            Document d = in.getElement();

            System.out.printf("Document n°%d is in BILL\n", d.getId());
            try {
                long dur = this.getDuration();
                System.out.println("Bill during " + dur + " ms");
                Thread.sleep(dur);
            } catch (InterruptedException ignored) {
            }
            if (d.mustPassToSend()) {
                d.setStatus(DocStatus.SEND);
                out.get(DocStatus.SEND).addElement(d);
            } else {
                d.setStatus(DocStatus.BACKUP);
                out.get(DocStatus.BACKUP).addElement(d);
            }

        }

    }
}
