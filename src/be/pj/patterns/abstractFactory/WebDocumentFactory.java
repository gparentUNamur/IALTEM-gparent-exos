package be.pj.patterns.abstractFactory;

public interface WebDocumentFactory {
    void appendHeading1(String text);

    void appendHeading2(String text);

    void appendHeading3(String text);

    void appendParagraph(String text);

    WebDocumentProduct generateProduct();
}
