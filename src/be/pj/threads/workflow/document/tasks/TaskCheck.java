package be.pj.threads.workflow.document.tasks;

import be.pj.threads.common.DocumentQueue;
import be.pj.threads.workflow.document.DocStatus;
import be.pj.threads.workflow.document.Document;

import java.util.Map;


public class TaskCheck extends Task {


    public TaskCheck(DocumentQueue in, Map<DocStatus, DocumentQueue> out) {
        super(in, out);
    }

    @Override
    public void run() {
        while (true) {
            Document d = in.getElement();
            try {
                long dur = this.getDuration();
                System.out.println("Check during " + dur + " ms");
                Thread.sleep(dur);
            } catch (InterruptedException ignored) {
            }
            if (d.getConformity()) {
                d.setStatus(DocStatus.DISPATCH);
                out.get(DocStatus.DISPATCH).addElement(d);
            } else {
                d.setStatus(DocStatus.TRASH);
                out.get(DocStatus.TRASH).addElement(d);
            }
        }
    }
}
