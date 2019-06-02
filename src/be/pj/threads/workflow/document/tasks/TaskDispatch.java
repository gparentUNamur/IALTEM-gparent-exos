package be.pj.threads.workflow.document.tasks;

import be.pj.threads.common.DocumentQueue;
import be.pj.threads.workflow.document.DocStatus;
import be.pj.threads.workflow.document.Document;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TaskDispatch extends Task {
    private static List<DocStatus> status = Arrays.asList(DocStatus.ORDER, DocStatus.BILL, DocStatus.SEND);

    public TaskDispatch(DocumentQueue in, Map<DocStatus, DocumentQueue> out) {
        super(in, out);
    }

    @Override
    public void run() {
        while (true) {
            Document d = in.getElement();
            d.setStatus(status.get(Math.abs(this.randomFactor.nextInt() % 3)));

            try {
                long dur = this.getDuration();
                System.out.println("DISPATCH during " + dur + " ms");
                Thread.sleep(dur);
            } catch (InterruptedException ignored) {
            }

            System.out.printf("Document n°%d is now in status %s", d.getId(), d.getStatus());
            out.get(d.getStatus()).addElement(d);
        }
    }
}
