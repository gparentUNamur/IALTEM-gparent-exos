package be.pj.threads.workflow.document.tasks;

import be.pj.threads.common.DocumentQueue;
import be.pj.threads.workflow.document.DocStatus;
import be.pj.threads.workflow.document.Document;

import java.util.Map;

public class TaskOrder extends Task {

    public TaskOrder(DocumentQueue in, Map<DocStatus, DocumentQueue> out) {
        super(in, out);
    }

    @Override
    public void run() {
        while (true) {
            Document d = in.getElement();

            System.out.printf("Document n°%d is in Order, copy in Bill & Send\n", d.getId());

            try {
                long dur = this.getDuration();
                System.out.println("ORDER during " + dur + " ms");
                Thread.sleep(dur);
            } catch (InterruptedException ignored) {
            }
            d.setStatus(DocStatus.BILL);
            out.get(DocStatus.BILL).addElement(d);

        }
    }
}
