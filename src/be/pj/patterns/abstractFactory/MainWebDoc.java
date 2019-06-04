package be.pj.patterns.abstractFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainWebDoc {
    public static void main(String[] args) throws IOException {
        WebDocumentFactory htmlFactory = new HtmlFactory();
        WebDocumentFactory mdFactory = new MarkDownFactory();

        List<WebDocumentFactory> factories = new ArrayList<>();
        factories.add(htmlFactory);
        factories.add(mdFactory);


        for (WebDocumentFactory f : factories) {
            f.appendHeading1("Gros titre");
            f.appendParagraph("Introduction text");
            f.appendHeading2("Heading 2");
            f.appendParagraph("Head2 text");

            f.appendHeading3("Head 3");
            f.appendParagraph("Head3 text");

            f.generateProduct().generateFile("content");
        }
    }
}
