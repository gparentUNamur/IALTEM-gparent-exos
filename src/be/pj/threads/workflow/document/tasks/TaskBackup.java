package be.pj.threads.workflow.document.tasks;

import be.pj.threads.common.DocumentQueue;
import be.pj.threads.workflow.document.DocStatus;
import be.pj.threads.workflow.document.Document;

import java.io.*;
import java.util.Map;

public class TaskBackup extends Task {

    private File file;

    public TaskBackup(DocumentQueue in, Map<DocStatus, DocumentQueue> out, File f) {
        super(in, out);
        this.file = f;
    }

    @Override
    public void run() {
        while (true) {
            Document d = in.getElement();

            System.out.printf("Document n°%d will be backuped\n", d.getId());

            File f = this.file;


            try {
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(d.toString());
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
