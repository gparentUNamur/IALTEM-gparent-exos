package be.pj.patterns.abstractFactory;

import java.util.ArrayList;
import java.util.List;

public class HtmlFactory implements WebDocumentFactory {
    List<String> doc = new ArrayList<>();

    @Override
    public void appendHeading1(String text) {
        doc.add("<h1>" + text + "</h1>");
    }

    @Override
    public void appendHeading2(String text) {
        doc.add("<h2>" + text + "</h2>");
    }

    @Override
    public void appendHeading3(String text) {
        doc.add("<h3>" + text + "</h3>");
    }

    @Override
    public void appendParagraph(String text) {
        doc.add("<p>" + text + "</p>");
    }

    @Override
    public HtmlProduct generateProduct() {
        return new HtmlProduct(this.doc);
    }
}
