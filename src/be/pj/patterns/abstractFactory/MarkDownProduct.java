package be.pj.patterns.abstractFactory;

import java.io.*;
import java.util.List;

public class MarkDownProduct implements WebDocumentProduct {
    List<String> doc;

    protected MarkDownProduct(List<String> doc) {
        this.doc = doc;
    }

    @Override
    public void generateFile(String path) throws IOException {
        File f = new File(path + ".md");
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        for (String s : this.doc) {
            pw.println(s);
        }

        pw.close();
    }
}
