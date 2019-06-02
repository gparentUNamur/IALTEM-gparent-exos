package be.pj.threads.workflow.document;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Document {
    private DocStatus status;
    private Random randomFactor;
    private List<DocStatus> history = new ArrayList<>();
    private int id;
    private boolean passedByOrder = false;

    public Document(DocStatus status, int id) {
        this.status = status;
        this.randomFactor = new Random();
        this.id = id;
    }

    public boolean getConformity() {
        return this.randomFactor.nextBoolean();
    }

    public DocStatus getStatus() {
        return status;
    }

    public void setStatus(DocStatus status) {
        this.status = status;
        history.add(status);
        System.err.println("Pass to " + status + this.toString());
        if (status.equals(DocStatus.ORDER)) {
            this.passedByOrder = true;
        }
    }

    public boolean mustPassToSend() {
        return this.passedByOrder;
    }

    @Override
    public String toString() {
        return String.format("Document n°%d pass states : %s", getId(), history.toString());
    }

    public int getId() {
        return this.id;
    }
}
