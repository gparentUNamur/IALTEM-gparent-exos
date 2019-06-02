package be.pj.threads.workflow.document;


import be.pj.threads.common.DocumentQueue;

public class DocumentGenerator implements Runnable {
    private DocumentQueue mapQueue;
    int id = 0;

    public DocumentGenerator(DocumentQueue queue) {
        this.mapQueue = queue;
    }

    @Override
    public void run() {
        while (id <= 10) {
            this.mapQueue.addElement(new Document(DocStatus.CHECK, id));
            System.out.printf("Doc n°%d inserted\n", id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            id++;
        }
    }
}
