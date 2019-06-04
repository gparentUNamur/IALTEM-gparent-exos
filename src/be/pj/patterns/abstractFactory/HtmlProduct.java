package be.pj.patterns.abstractFactory;

import java.io.*;
import java.util.List;

public class HtmlProduct implements WebDocumentProduct {
    List<String> doc;

    protected HtmlProduct(List<String> doc) {
        this.doc = doc;
    }


    @Override
    public void generateFile(String path) throws IOException {
        File f = new File(path + ".html");
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("<html>\n<body>");
        for (String s : this.doc) {
            pw.println(s);
        }

        pw.println("</body>\n</html>");
        pw.close();
    }

}
