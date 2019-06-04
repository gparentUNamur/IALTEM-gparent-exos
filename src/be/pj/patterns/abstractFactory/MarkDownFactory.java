package be.pj.patterns.abstractFactory;

import java.util.ArrayList;
import java.util.List;

public class MarkDownFactory implements WebDocumentFactory {
    List<String> doc = new ArrayList<>();

    @Override
    public void appendHeading1(String text) {
        doc.add("# " + text);
    }

    @Override
    public void appendHeading2(String text) {
        doc.add("## " + text);
    }

    @Override
    public void appendHeading3(String text) {
        doc.add("## " + text);
    }

    @Override
    public void appendParagraph(String text) {
        doc.add(text);
    }

    @Override
    public MarkDownProduct generateProduct() {
        return new MarkDownProduct(this.doc);
    }
}
